# Generated by Django 2.2.25 on 2021-12-20 17:17

from django.conf import settings
from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        migrations.swappable_dependency(settings.AUTH_USER_MODEL),
        ('sitemanager', '0005_auto_20211220_0339'),
    ]

    operations = [
        migrations.AddField(
            model_name='pdf',
            name='username',
            field=models.ForeignKey(null=True, on_delete=django.db.models.deletion.CASCADE, to=settings.AUTH_USER_MODEL),
        ),
    ]
