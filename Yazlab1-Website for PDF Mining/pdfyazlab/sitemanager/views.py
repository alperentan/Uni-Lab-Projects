from django.shortcuts import  get_object_or_404, render, redirect
from .forms import EditUserForm, NewUserForm,PdfForm
from django.contrib.auth import login, authenticate, logout
from django.contrib import messages
from django.contrib.auth.forms import AuthenticationForm
from django.contrib.auth.models import User
from .models import *
from .forms import *
from unidecode import unidecode
from django.db.models import Q
super_user_log=False
def homepage(request):
	return render(request=request, template_name='sitemanager/home.html')

def register_request(request):
	global super_user_log
	if request.method == "POST":
		form = NewUserForm(request.POST)
		if form.is_valid():
			user = form.save()
			if(super_user_log):
				pass
			else:
				login(request, user)
			messages.success(request, "Registration successful." )
			return redirect("sitemanager:homepage")
		messages.error(request, "Unsuccessful registration. Invalid information.")
	form = NewUserForm()
	return render (request=request, template_name="sitemanager/register.html", context={"register_form":form})

def login_request(request):
	global super_user_log
	if request.method == "POST":
		form = AuthenticationForm(request, data=request.POST)
		if form.is_valid():
			username = form.cleaned_data.get('username')
			password = form.cleaned_data.get('password')
			user = authenticate(username=username, password=password)
			if user is not None:
				login(request, user)
				super_user_log=True
				messages.info(request, f"You are now logged in as {username}.")
				return redirect("sitemanager:homepage")
			else:
				messages.error(request,"Invalid username or password.")
		else:
			messages.error(request,"Invalid username or password.")
	form = AuthenticationForm()
	return render(request=request, template_name="sitemanager/login.html", context={"login_form":form})

def logout_request(request):
	global super_user_log
	logout(request)
	super_user_log=False
	messages.info(request, "You have successfully logged out.") 
	return redirect("sitemanager:homepage")

def view_users_request(request):
	users=User.objects.all()
	return render(request=request, template_name="sitemanager/users_table.html", context={"users":users})


def update_users_request(request,id):
	if request.method == "POST":
		ex_user=get_object_or_404(User,id=id)
		form = EditUserForm(request.POST,instance=ex_user)
		if form.is_valid():
			user = form.save()
			messages.success(request, "Update successful." )
			return redirect("sitemanager:users")
		messages.error(request, "Unsuccessful registration. Invalid information.")
	form = NewUserForm()
	return render(request=request, template_name="sitemanager/update_user.html",context={"update_form":form})

def delete_users_request(request,id):
	ex_user=get_object_or_404(User,id=id)
	ex_user.delete()
	messages.success(request, "Deletion successful." )
	return redirect("sitemanager:users")


def show_pdf_data(request):
	#context = {}
	#context['pdfs'] = Pdf.objects.all()
	#return render(request=request,template_name="sitemanager/data_table.html",context=context)
	testdata = Pdf.objects.filter(username=request.user)
	print(testdata)
	return render(request, "sitemanager/data_table.html", {"pdfs": testdata})

def show_pdf_data_admin(request):
	context = {}
	context['pdfs'] = Pdf.objects.all()
	return render(request=request,template_name="sitemanager/admin_datatable.html",context=context)
	#testdata = Pdf.objects.filter(username=request.user)
	#print(testdata)
	#return render(request, "sitemanager/data_table.html", {"pdfs": testdata})

def show_query2_admin(request):

	if request.method== 'POST':
		form = adminSelectForm(request.POST)
		if form.is_valid():
			donem=form.cleaned_data.get('donemtxt')
			isim=form.cleaned_data.get('isimtxt')
			ders=form.cleaned_data.get('derstxt')
			filter=Pdf.objects.filter(Q(ders_adi__icontains=ders),Q(proje_teslim_donemi__icontains=donem),Q(ogr_adi__icontains=isim))
			return render(request,"sitemanager/admin_datatable.html",{"pdfs":filter})
	return render(request,"sitemanager/query2.html",{"pdfs":adminSelectForm})

def show_query1_admin(request):
	if request.method== 'POST':
		form = query1Form(request.POST)
		if form.is_valid():
			field=form.cleaned_data.get('query1_field')
			txt=form.cleaned_data.get('query1_fieldtxt')
			if(field=='1'):
				filter = Pdf.objects.filter(Q(ogr_adi__icontains=txt))
			elif(field=='2'):
				filter = Pdf.objects.filter(Q(ders_adi__icontains=txt))
			elif (field == '3'):
				filter = Pdf.objects.filter(Q(proje_basligi__icontains=txt))
			elif (field == '4'):
				filter = Pdf.objects.filter(Q(anahtar_kelimeler__icontains=txt))
			elif (field == '5'):
				filter = Pdf.objects.filter(Q(proje_teslim_donemi__icontains=txt))
			return render(request,"sitemanager/admin_datatable.html",{"pdfs":filter})
	return render(request,"sitemanager/query1.html",{"pdfs":query1Form})



def pdf_data_detail(request,id):
	dataDetail = get_object_or_404(Pdf,id=id)
	return render(request,"sitemanager/data_detail.html",{"dataDetail":dataDetail})

def pdf_upload(request):
	if request.method == 'GET':
		#form=PdfForm()
		return render(request=request, template_name="sitemanager/upload_pdf.html", context={"upload_form":PdfForm()})
	elif request.method== 'POST':
		# Passing uploaded files as request.files
		form = PdfForm(request.POST, request.FILES)
		print(form.instance.ogr_no)
		# Validating and saving the form
		if form.is_valid():
			form.instance.username=request.user
			path = "C:\\Users\\tanal\\Desktop\\"
			pdfPath = form.cleaned_data.get('pdf')
			absolutePath = path+str(pdfPath)
			returnParseData = parse_pdfOCR(absolutePath)  ###OCR ile PDF okuma
			#returnParseData = parse_pdfWT(absolutePath) ###pdfminer ile text çekerek PDF okuma
			form.instance.ogr_no = returnParseData[0]
			form.instance.ogr_adi = returnParseData[1]
			form.instance.ogr_tur = returnParseData[2]
			form.instance.proje_basligi = returnParseData[3]
			form.instance.anahtar_kelimeler = returnParseData[4]
			form.instance.ders_adi = returnParseData[5]
			form.instance.proje_ozeti = returnParseData[6]
			form.instance.proje_teslim_donemi = returnParseData[7]
			form.instance.danisman_bilgileri = returnParseData[8]
			form.instance.juri_bilgileri = returnParseData[9]
			form.save()
			return redirect(("sitemanager:show_data"))
		else:
			context = {"upload_form":form}
			return render(request, 'sitemanager/upload_pdf.html', context)
