from django.urls import path
from . import views

app_name = "sitemanager"   


urlpatterns = [
    path("", views.homepage, name="homepage"),
    path("register", views.register_request, name="register"),
    path("login", views.login_request, name="login"),
    path("logout", views.logout_request, name= "logout"),
    path("users", views.view_users_request, name= "users"),
    path("add_pdf", views.pdf_upload, name= "add_pdf"),
    path("show_data", views.show_pdf_data, name= "show_data"),
    path("show_data_admin", views.show_pdf_data_admin, name= "show_data_admin"),
    path("data_detail/<int:id>", views.pdf_data_detail, name= "detail_data"),
    path("update_user/<int:id>", views.update_users_request, name= "update_user"),
    path("delete_user/<int:id>", views.delete_users_request, name= "delete_user"),
    path("query2", views.show_query2_admin, name= "query2"),
    path("query1", views.show_query1_admin, name= "query1"),
]