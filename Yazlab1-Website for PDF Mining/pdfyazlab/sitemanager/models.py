from django.db import models
from django.contrib.auth.models import User


class Pdf(models.Model):
    id = models.BigAutoField(
        primary_key=True,
    )

    username = models.ForeignKey(User,on_delete=models.CASCADE,null=True)

    ogr_adi = models.CharField(
        max_length=150,
        null=True,
        verbose_name='Ogrenci Adi'
    )
    ogr_no = models.CharField(
        max_length=150,
        null=True,
        verbose_name='Ogrenci No'
    )
    ogr_tur = models.CharField(
        max_length=150,
        null=True,
        verbose_name='Ogretim Turu'
    )
    ders_adi = models.CharField(
        max_length=150,
        verbose_name='Ders'
    )
    proje_ozeti = models.TextField(
        max_length=4000,
        verbose_name='Ozet'
    )
    proje_teslim_donemi = models.CharField(
        max_length=150,
        verbose_name='Teslim Donemi'
    )
    proje_basligi = models.CharField(
        max_length=500,
        verbose_name='Proje Basligi'
    )
    anahtar_kelimeler = models.CharField(
        max_length=700,
        verbose_name='Anahtar Kelimeler'
    )
    danisman_bilgileri = models.CharField(
        max_length=400,
        verbose_name='Danisman Bilgileri'
    )
    juri_bilgileri = models.CharField(
        max_length=400,
        verbose_name='Juri Bilgileri'
    )
    pdf= models.FileField(
        upload_to='downloads',
        verbose_name = 'PDF dosyasi'
    )
