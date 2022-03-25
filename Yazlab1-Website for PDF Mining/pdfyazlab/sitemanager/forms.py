from django import forms
from django.contrib.auth.forms import UserCreationForm,UserChangeForm
from django.contrib.auth.models import User
from .models import *
import pytesseract
from PIL import Image
from pdf2image import convert_from_path
import os
import sys
from itertools import islice
import datetime
import unidecode
from pdfminer.high_level import extract_text
import os
import datetime
from .views import *
QUERYSELECT_CHOICES=(
    ("1", "Yazar"),
    ("2", "Ders"),
    ("3", "Proje Adi"),
    ("4", "Anahtar Kelimeler"),
    ("5", "Teslim Dönemi"),
)

# creating a form
class query1Form(forms.Form):
   query1_field = forms.ChoiceField(label='Sorgu tipi',choices = QUERYSELECT_CHOICES)
   query1_fieldtxt = forms.CharField(label='Girilen sorgu kelimesi',max_length=200)

class NewUserForm(UserCreationForm):
	email = forms.EmailField(required=True)
	
	class Meta:
		model = User
		fields = ("username", "email", "password1", "password2","is_superuser")

	def save(self, commit=True):
		user = super(NewUserForm, self).save(commit=False)
		user.email = self.cleaned_data['email']
		if commit:
			user.save()
		return user

class EditUserForm(UserChangeForm):
	email = forms.EmailField(required=True)
	
	class Meta:
		model = User
		fields = ("username", "email","is_superuser")

	def save(self, commit=True):
		user = super(EditUserForm, self).save(commit=False)
		user.email = self.cleaned_data['email']
		if commit:
			user.save()
		return user

class PdfForm(forms.ModelForm):
	#pdf_file=forms.FileField()
	class Meta:
		model = Pdf
		fields = ("pdf",)
		#fields = '__all__'
def parse_pdfOCR(path):
	pytesseract.pytesseract.tesseract_cmd = r"C:\Program Files (x86)\Tesseract-OCR\tesseract.exe"
	PDF_file = path
	pages = convert_from_path(PDF_file, 500)
	image_counter = 1
	for page in pages:
		filename = "C:\\Users\\tanal\\Desktop\\pdfyazlab\\uploads\\downloads\\pages\\"+"page_" + str(image_counter) + ".jpg"
		page.save(filename, 'JPEG')
		image_counter = image_counter + 1
		print(image_counter)

	filelimit = image_counter - 1
	image_counter2 = 1

	outfile = "out_text.txt"
	f = open(outfile, "a")
	for i in range(1, filelimit + 1):
		filename = "C:\\Users\\tanal\\Desktop\\pdfyazlab\\uploads\\downloads\\pages\\"+"page_" + str(i) + ".jpg"
		text = str(pytesseract.image_to_string(Image.open(filename), lang="tur"))
		os.remove("C:\\Users\\tanal\\Desktop\\pdfyazlab\\uploads\\downloads\\pages\\" + "page_" + str(image_counter2) + ".jpg")
		text = text.replace('-\n', '')
		f.write(text + "\n\n")
		print(i)
		image_counter2 = image_counter2 + 1
	f.close()

	outfile = "pdfyazlab\\out_text.txt"

	def search_string_in_txt_same_line(string):
		returnadsoyadstring = ""
		found = False
		with open(outfile) as f:
			for line in f:
				if string in line:
					found = True
				if found:
					returnadsoyadstring += line
					found = False
			return returnadsoyadstring

	def search_proje_basligi(string, ogrenciadi):
		returnprojebasligistring = ""
		with open(outfile) as f:
			for line in f:
				if string in line:
					for line in f:
						if ogrenciadi.split()[1] in line:
							break
						else:
							returnprojebasligistring += line;
			return returnprojebasligistring

	def search_anahtar_kelimeler(string):
		"""with open(outfile) as f:
            for line in f:
                if string in line:
                    return line+(''.join(islice(f, 1)))"""
		returnanahtarkelimelerstring = ""
		with open(outfile) as f:
			for line in f:
				if string in line:
					returnanahtarkelimelerstring += line
					for line in f:
						if line.isspace():
							break
						else:
							returnanahtarkelimelerstring += line
			return returnanahtarkelimelerstring

	def search_ozet(string):
		contains = False
		ozetstringi = ""
		with open(outfile, 'r') as f:
			for line in f:
				if string in line:
					if not ".." in line:
						contains = True
				if (contains):
					if "Anahtar kelimeler" in line:
						return ozetstringi
						break
					else:
						ozetstringi += line

	def search_ders_adi(string, baslikstring):
		returndersadistring = ""
		"""with open(outfile) as f:
            for line in f:
                if string in line:
                    if "BİTİRME PROJESİ" or "ARAŞTIRMA PROBLEMLERİ" in (''.join(islice(f, 1))):
                        return (''.join(islice(f, 2)))"""
		with open(outfile) as f:
			for line in f:
				if string in line:
					for line in f:
						if baslikstring in line:
							break
						elif "BİTİRME PROJESİ" in line or "ARAŞTIRMA PROBLEMLERİ" in line:
							returndersadistring += line

			return returndersadistring

	def search_danisman(string):
		"""indexx=0
        with open(outfile) as f:
            for line in f:
                indexx+=1
                if string in line:
                    f.seek(0)
                    return (''.join(islice(f,indexx-3,indexx-2)))
                    break"""
		N = 2
		returndanismanstring = ""
		with open(outfile, 'r') as f:
			lines = f.read().splitlines()
			for i, line in enumerate(lines):
				if string in line:
					j = i - N if i > N else 0
					for k in range(j, i):
						# print(lines[k])
						returndanismanstring += lines[k] + "\n"
		return returndanismanstring

	def search_juri(string):
		returnjuristring = ""
		with open(outfile, 'r') as f:
			# lines = f.read().splitlines()
			for line in f:
				if string in line:
					for line in f:
						if "Tezin Savunulduğu Tarih:" in line:
							break
						else:
							if "Jüri Üyesi," not in line:
								returnjuristring += line
			return returnjuristring

	def find_ogretim(string):
		if (string[5] == '1'):
			return "Birinci Öğretim"
		else:
			return "İkinci Öğretim"

	outfile = "out_text.txt"
	ogrencinostring = 'Öğrenci No:'
	adsoyadstring = 'Adı Soyadı:'
	projebasligistring = 'LİSANS TEZİ'
	anahtarkelimelerstring = 'Anahtar kelimeler:'
	ozetstring = 'ÖZET'
	dersadistring = 'BÖLÜMÜ'
	donemstring = "Tezin Savunulduğu Tarih:"
	danismanstring = "Danışman"
	juristring = "Danışman,"

	ogrenci_no = search_string_in_txt_same_line(ogrencinostring)
	ogrenci_no = ogrenci_no.replace("Öğrenci No: ", "")  # string icinde ogrenci no:'yu kaldirir
	ogrenci_no = os.linesep.join(
		[s for s in ogrenci_no.splitlines() if s])  # eger string bos satir barindiriyorsa bos satiri kaldirir
	ogrenci_no = " ".join(ogrenci_no.splitlines())
	print("No:" + ogrenci_no)

	ogrenci_adi = search_string_in_txt_same_line(adsoyadstring)
	ogrenci_adi = ogrenci_adi.replace("Adı Soyadı: ", "")  # string icinde adi soyadi: kismini kaldirir
	ogrenci_adi = os.linesep.join(
		[s for s in ogrenci_adi.splitlines() if s])  # eger string bos satir barindiriyorsa bos satiri kaldirir
	ogrenci_adi = " ".join(ogrenci_adi.splitlines())
	ogrenci_adi = ogrenci_adi.upper()
	print("Ad Soyad:" + ogrenci_adi)

	proje_basligi = search_proje_basligi(projebasligistring, ogrenci_adi)
	proje_basligi = proje_basligi.replace("\n", " ")  # birden cok satiri tek satira cevirme
	print("Baslik:" + proje_basligi)

	anahtar_kelimeler = search_anahtar_kelimeler(anahtarkelimelerstring)
	anahtar_kelimeler = anahtar_kelimeler.replace("\n", " ")  # birden cok satiri tek satira cevirme
	print(anahtar_kelimeler)

	dersadi = search_ders_adi(dersadistring, proje_basligi)
	dersadi = dersadi.replace("\n", " ")  # birden cok satiri tek satira cevirme
	print("Ders adı:" + dersadi)

	ozet = search_ozet(ozetstring)
	ozet = ozet.replace("ÖZET", "")
	print("Özet:" + ozet)

	teslimDonemi = search_string_in_txt_same_line(donemstring)
	teslimDonemi = teslimDonemi.replace(donemstring, "")  # string icinde ogrenci no:'yu kaldirir
	teslimDonemi = os.linesep.join(
		[s for s in teslimDonemi.splitlines() if s])  # eger string bos satir barindiriyorsa bos satiri kaldirir
	tarih = teslimDonemi
	datee = datetime.datetime.strptime(tarih, " %d.%m.%Y")
	if (9 <= datee.month <= 12):
		teslimDonemi = str(datee.year) + "-" + str(datee.year + 1) + " Güz"
	elif (datee.month == 1):
		teslimDonemi = str(datee.year - 1) + "-" + str(datee.year) + " Güz"
	elif (2 <= datee.month <= 9):
		teslimDonemi = str(datee.year - 1) + "-" + str(datee.year) + " Bahar"
	print("Teslim dönemi:" + teslimDonemi)

	danismanIsmi = search_danisman(danismanstring)
	danismanIsmi = os.linesep.join(
		[s for s in danismanIsmi.splitlines() if s])  # eger string bos satir barindiriyorsa bos satiri kaldirir
	print("Danışman:\n" + danismanIsmi)

	juriIsimleri = search_juri(juristring)
	juriIsimleri = os.linesep.join(
		[s for s in juriIsimleri.splitlines() if s])  # eger string bos satir barindiriyorsa bos satiri kaldirir
	print("Jüriler:\n" + juriIsimleri)

	ogretimTuru = find_ogretim(ogrenci_no)
	print(ogretimTuru)
	open('out_text.txt', 'w').close()

	return ogrenci_no,ogrenci_adi,ogretimTuru,proje_basligi,anahtar_kelimeler,dersadi,ozet,teslimDonemi,danismanIsmi,juriIsimleri,ogretimTuru

class adminSelectForm(forms.Form):
	 donemtxt = forms.CharField(label='Donem',max_length=150)
	 isimtxt = forms.CharField(label='Isim',max_length=150)
	 derstxt = forms.CharField(label='Ders',max_length=150)

def parse_pdfWT(path):
	text = extract_text(path)
	print(text)

	def search_string_in_txt_same_line(string):
		returnadsoyadstring = ""
		found = False
		for line in text.splitlines():
			if string in line:
				found = True
			if found:
				returnadsoyadstring += line
				found = False
		return returnadsoyadstring

	def search_proje_basligi(string, adstringi):
		returnprojebasligistring = ""
		it = iter(text.splitlines())
		for line in it:
			if string in line:
				for line in it:
					if line.isspace():
						break
					else:
						returnprojebasligistring += line
		return returnprojebasligistring

	def search_anahtar_kelimeler(string):
		returnanahtarkelimelerstring = ""
		it = iter(text.splitlines())
		for line in it:
			if string in line:
				returnanahtarkelimelerstring += line
				for line in it:
					if line.isspace():
						break
					else:
						returnanahtarkelimelerstring += line
		return returnanahtarkelimelerstring

	def search_ozet(string):
		contains = False
		ozetstringi = ""
		for line in text.splitlines():
			if string in line:
				if not ".." in line:
					contains = True
			if (contains):
				if "Anahtar  kelimeler:" in line:
					return ozetstringi
					break
				else:
					ozetstringi += line

	def search_ders_adi(string, baslikstring):
		returndersadistring = ""
		it = iter(text.splitlines())
		"""with open(outfile) as f:
            for line in f:
                if string in line:
                    if "BİTİRME PROJESİ" or "ARAŞTIRMA PROBLEMLERİ" in (''.join(islice(f, 1))):
                        return (''.join(islice(f, 2)))"""
		for line in it:
			if string in line:
				for line in it:
					if baslikstring in line:
						break
					elif "BİTİRME PROJESİ" in line or "ARAŞTIRMA PROBLEMLERİ" in line:
						returndersadistring += line

		return returndersadistring

	def search_danisman(string):
		"""indexx=0
        with open(outfile) as f:
            for line in f:
                indexx+=1
                if string in line:
                    f.seek(0)
                    return (''.join(islice(f,indexx-3,indexx-2)))
                    break"""
		N = 2
		returndanismanstring = ""
		lines = text.splitlines()
		for i, line in enumerate(lines):
			if string in line:
				j = i - N if i > N else 0
				for k in range(j, i):
					# print(lines[k])
					returndanismanstring += lines[k] + "\n"
		return returndanismanstring

	def search_juri(string):
		returnjuristring = ""
		it = iter(text.splitlines())
		for line in it:
			if string in line:
				for line in it:
					if "..." in line:
						break
					else:
						if "Jüri Üyesi," not in line:
							returnjuristring += line
		return returnjuristring

	def find_ogretim(string):
		if (string[5] == '1'):
			return "Birinci Öğretim"
		else:
			return "İkinci Öğretim"

	ogrencinostring = 'Öğrenci No:'
	adsoyadstring = 'Adı Soyadı:'
	projebasligistring = 'LİSANS TEZİ'
	anahtarkelimelerstring = 'Anahtar  kelimeler:'
	ozetstring = 'ÖZET'
	dersadistring = 'BÖLÜMÜ'
	donemstring = "Tezin Savunulduğu Tarih:"
	danismanstring = "Danışman"
	juristring = "Danışman,"

	ogrenci_no = search_string_in_txt_same_line(ogrencinostring)
	ogrenci_no = ogrenci_no.replace("Öğrenci No: ", "")  # string icinde ogrenci no:'yu kaldirir
	ogrenci_no = os.linesep.join(
		[s for s in ogrenci_no.splitlines() if s])  # eger string bos satir barindiriyorsa bos satiri kaldirir
	print("No:" + ogrenci_no)

	ogrenci_adi = search_string_in_txt_same_line(adsoyadstring)
	ogrenci_adi = ogrenci_adi.replace("Adı Soyadı: ", "")  # string icinde adi soyadi: kismini kaldirir
	ogrenci_adi = os.linesep.join(
		[s for s in ogrenci_adi.splitlines() if s])  # eger string bos satir barindiriyorsa bos satiri kaldirir
	print("Ad Soyad:" + ogrenci_adi)

	proje_basligi = search_proje_basligi(projebasligistring, ogrenci_adi)
	proje_basligi = proje_basligi.replace("\n", " ")  # birden cok satiri tek satira cevirme
	print("Baslik:" + proje_basligi)

	anahtar_kelimeler = search_anahtar_kelimeler(anahtarkelimelerstring)
	anahtar_kelimeler = anahtar_kelimeler.replace("\n", " ")  # birden cok satiri tek satira cevirme
	print(anahtar_kelimeler)

	dersadi = search_ders_adi(dersadistring, proje_basligi)
	dersadi = dersadi.replace("\n", " ")  # birden cok satiri tek satira cevirme
	print("Ders adı:" + dersadi)

	ozet = search_ozet(ozetstring)
	ozet = ozet.replace("ÖZET", "")
	print("Özet:" + ozet)
	print(ozet)

	teslimDonemi = search_string_in_txt_same_line(donemstring)
	teslimDonemi = teslimDonemi.replace(donemstring, "")  # string icinde ogrenci no:'yu kaldirir
	teslimDonemi = os.linesep.join(
		[s for s in teslimDonemi.splitlines() if s])  # eger string bos satir barindiriyorsa bos satiri kaldirir
	tarih = teslimDonemi
	# print(tarih)
	datee = datetime.datetime.strptime(tarih, " %d.%m.%Y ")
	if (9 <= datee.month <= 12):
		teslimDonemi = str(datee.year) + "-" + str(datee.year + 1) + " Güz"
	elif (datee.month == 1):
		teslimDonemi = str(datee.year - 1) + "-" + str(datee.year) + " Güz"
	elif (2 <= datee.month <= 9):
		teslimDonemi = str(datee.year - 1) + "-" + str(datee.year) + " Bahar"
	print("Teslim dönemi:" + teslimDonemi)

	danismanIsmi = search_danisman(danismanstring)
	danismanIsmi = os.linesep.join(
		[s for s in danismanIsmi.splitlines() if s])  # eger string bos satir barindiriyorsa bos satiri kaldirir
	print("Danışman:\n" + danismanIsmi)

	juriIsimleri = search_juri(juristring)
	juriIsimleri = os.linesep.join(
		[s for s in juriIsimleri.splitlines() if s])  # eger string bos satir barindiriyorsa bos satiri kaldirir
	print("Jüriler:\n" + juriIsimleri)

	ogretimTuru = find_ogretim(ogrenci_no)
	print("Öğretim türü:" + ogretimTuru)

	return ogrenci_no, ogrenci_adi, ogretimTuru, proje_basligi, anahtar_kelimeler, dersadi, ozet, teslimDonemi, danismanIsmi, juriIsimleri, ogretimTuru