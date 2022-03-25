using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using GMap.NET;
using GMap.NET.MapProviders;
using GMap.NET.WindowsForms;
using GMap.NET.WindowsForms.Markers;
using System.Threading;
using System.Net.Http;
using System.Net.Http.Formatting;
using Newtonsoft.Json.Linq;
using Newtonsoft.Json;
using System.Net.Http.Headers;
using RestSharp;

namespace Yazlab1_1Kargo
{
    public partial class Form1 : Form
    {
        List<Node> delivered = new List<Node>();
        PointLatLng reg = new PointLatLng();
        Node lastDel = new Node();
        Form2 formGlob;
        int id = 0;
        List<PointLatLng> pDel = new List<PointLatLng>();
        double kullaniciLat;
        double kullaniciLng;
        public Form1()
        {
            InitializeComponent();
            lastDel.id = -1;
            GMapProviders.GoogleMap.ApiKey = @"AIzaSyCBcEiDsMVQSkuf47r7zBYU16et6KPO7vg";
            GMaps.Instance.Mode = AccessMode.ServerAndCache;
            createCargoPanMap.CacheLocation = @"cache";
            createCargoPanMap.DragButton = MouseButtons.Right;
            createCargoPanMap.MapProvider = GMapProviders.GoogleMap;
            createCargoPanMap.ShowCenter=false;
            createCargoPanMap.MinZoom = 5;
            createCargoPanMap.MaxZoom = 100;
            createCargoPanMap.Zoom = 15;
            createCargoPanMap.SetPositionByKeywords("Kocaeli, Türkiye");
            registerPanNewUserMap.CacheLocation = @"cache";
            registerPanNewUserMap.DragButton = MouseButtons.Right;
            registerPanNewUserMap.MapProvider = GMapProviders.GoogleMap;
            registerPanNewUserMap.ShowCenter=false;
            registerPanNewUserMap.MinZoom = 5;
            registerPanNewUserMap.MaxZoom = 100;
            registerPanNewUserMap.Zoom = 15;
            registerPanNewUserMap.SetPositionByKeywords("Kocaeli, Türkiye");
            createCargoPanel.Hide();
            changePassPanel.Hide();
            registerPanel.Hide();
            userPanel.Hide();
            cargoTrackingPanel.Hide();
            createCargoPanCustomerAdress.Enabled = false;
            getDelPoint();
        }

        public async void getDelPoint()
        {
            var client = new HttpClient();
            client.BaseAddress = new Uri("http://yazlab1p1api20211026003801.azurewebsites.net");
            HttpResponseMessage responses = await client.GetAsync($"api/deliverypoints");
            string results = await responses.Content.ReadAsStringAsync();
            dynamic obj_strs = JsonConvert.DeserializeObject(results);
            foreach (var i in obj_strs)
            {
                PointLatLng nPoint = new PointLatLng();
                nPoint.Lng = i.deliveryPointsLocationLng;
                nPoint.Lat = i.deliveryPointsLocationLat;
                pDel.Add(nPoint);
            }
        }
        //Kullanıcı paneline giriş yapar
        private async void buttonLogPanLogin_Click(object sender, EventArgs e)
        {
            string user=loginPanUserName.Text;
            string pass = loginPanUserPass.Text;         
            var client = new HttpClient();
            client.BaseAddress = new Uri("http://yazlab1p1api20211026003801.azurewebsites.net");
            HttpResponseMessage response = await client.GetAsync($"api/users/{user}");
            string result = await response.Content.ReadAsStringAsync();          
            dynamic obj_str = JsonConvert.DeserializeObject(result);
            string dataName = null;
            string dataPw = null;            
            if (obj_str.Count > 0)
            {
                dataName = obj_str[0].userName;
                dataPw = obj_str[0].userPw;
                kullaniciLat = Convert.ToDouble(obj_str[0].userLocationLat);
                kullaniciLng = Convert.ToDouble(obj_str[0].userLocationLng);              
            }
            
            
            if (String.Equals(user, dataName) && String.Equals(pass, dataPw))
            {
                MessageBox.Show($"Hosgeldin {user}!");
                loginPanel.Hide();
                userPanel.Show();
            }
            else
            {
                MessageBox.Show($"Kullanici adi veya sifre yanlis!");
            }
        }
        //Kullanıcı kayıt panelini açar
        private void buttonLogPanRegister_Click(object sender, EventArgs e)
        {
            registerPanel.Show();
            loginPanel.Hide();
        }
        //Şifre değiştirme panelini açar
        private void buttonLoginPanChangePass_Click(object sender, EventArgs e)
        {       
            loginPanel.Hide();
            changePassPanel.Show();
        }
        //Kullanıcı Paneli Kargo İşlemleri
        private void buttonUserPanCargoCreate_Click(object sender, EventArgs e)
        {
            createCargoPanel.Show();
            userPanel.Hide();
        }
        //Kargo aracı panelini açar
        private void buttonUserPanCargoTracking_Click(object sender, EventArgs e)
        {
            HttpClient client = new HttpClient();
            client.BaseAddress = new Uri("http://yazlab1p1api20211026003801.azurewebsites.net");
            HttpResponseMessage response = client.GetAsync("api/deliveries").Result;
            var test = response.Content.ReadAsAsync<IEnumerable<Deliveries>>().Result;
            dataGridView1.DataSource = test;
            cargoTrackingPanel.Show();
            userPanel.Hide();
        }
        //Kullanıcı çıkış yapar login ekranına döner
        private void buttonUserPanLogOut_Click(object sender, EventArgs e)
        {
            loginPanel.Show();
            userPanel.Hide();
        }
        //Kargo aracı takip penceresini açar
        private async void buttonUserPanCargoMap_Click(object sender, EventArgs e)
        {
                Form2 form = new Form2();
                form.Show();
            delivered.Clear();
            form.minDs = 0;
            var clientdeli = new HttpClient();
            clientdeli.BaseAddress = new Uri("http://yazlab1p1api20211026003801.azurewebsites.net");
            HttpResponseMessage response = await clientdeli.GetAsync("api/deliveries");
            string result = await response.Content.ReadAsStringAsync();
            dynamic obj_str = JsonConvert.DeserializeObject(result);
            int ids = 0;
            List<Node> nodelist = new List<Node>();
            Node nkullanici = new Node();
            nkullanici.id = ids;
            PointLatLng reg1 = new PointLatLng();
            reg1.Lat = Convert.ToDouble(kullaniciLat);
            reg1.Lng = Convert.ToDouble(kullaniciLng);
            nkullanici.point = reg1;
            nkullanici.isUser = true;
            if (lastDel.id == 0)
            {
                nodelist.Add(lastDel);
            }
            else
            {
                nodelist.Add(nkullanici);
            }
            ids++;         
            foreach (var i in obj_str)
            {
                //Console.WriteLine(i.MusteriLocationLng + "-" + i.MusteriLocationLat);
                Node n = new Node();
                n.id = ids;
                PointLatLng reg2 = new PointLatLng();
                reg2.Lat = Convert.ToDouble(i.MusteriLocationLat);
                reg2.Lng = Convert.ToDouble(i.MusteriLocationLng);
                n.point = reg2;
                if (i.MusteriTeslim == "edildi")
                {
                    delivered.Add(n);
                }
                else
                {
                    nodelist.Add(n);                   
                }
                ids++;
                
            }
            form.cargoRoute(nodelist, delivered, nkullanici, pDel);
            formGlob = form;
        }
        /*
        Kullanıcı oluşturma paneli
        */

        //Basıldığında yeni kullanıcı oluşturur
        private void buttonRegisterPanCreateUser_Click(object sender, EventArgs e)
        {
            String userName = registerPanNewUserName.Text;
            String userPass = registerPanNewUserPass.Text;
            registerPanNewUserMap.SetPositionByKeywords(registerPanNewUserLocation.Text);
            var center = registerPanNewUserMap.Position;
            var centerLat = center.Lat;
            var centerLng = center.Lng;
            var addresses = GetAddress(center);
            if (String.IsNullOrEmpty(userName)||String.IsNullOrEmpty(userPass))
            {
                MessageBox.Show("Kullanıcı adı ve şifre boş olamaz!");
            }
            else
            {
                var client = new RestClient("https://yazlab1p1api20211026003801.azurewebsites.net/api/users");
                client.Timeout = -1;
                var request = new RestRequest(Method.POST);
                request.AddHeader("Content-Type", "application/json");
                request.AddHeader("Cookie", "ARRAffinity=92ca53ad8db4fbb93d4d3b7d8ab54dcf8ffecb2d731f25b0e91ad575d7534c3f; ARRAffinitySameSite=92ca53ad8db4fbb93d4d3b7d8ab54dcf8ffecb2d731f25b0e91ad575d7534c3f");
                JObject body = new JObject();
                body["userName"] = userName;
                body["userPw"] = userPass;
                body["userLocationLng"] = centerLng;
                body["userLocationLat"] = centerLat;

                request.AddParameter("application/json", body, ParameterType.RequestBody);
                IRestResponse response = client.Execute(request);

                MessageBox.Show("Başarıyla kayıt oldunuz!");
                registerPanel.Hide();
                loginPanel.Show();
            }
            


        }

        //Basıldığında kayıt panelinden login paneline döner
        private void buttonRegPanelBack_Click(object sender, EventArgs e)
        {
            registerPanel.Hide();
            loginPanel.Show();
        }
        //Şifre Değiştirme Paneli

        //Basıldığında şifre değiştirme panelinden login paneline geri döner
        private void changePassPanBack_Click(object sender, EventArgs e)
        {
            loginPanel.Show();
            changePassPanel.Hide();
        }

        //Basıldığında kullanıcı şifresini değiştirir
        private async void changePassPanChangePass_Click(object sender, EventArgs e)
        {
            string user = changePassPanUserName.Text;
            string pass = changePassPanUserNewPass.Text;
            string pass2 = changePassPanUserPassVerify.Text;
            if (String.IsNullOrEmpty(user))
            {
                MessageBox.Show("Kullanıcı adı boş olamaz!");
            }
            else
            {
                if (String.Equals(pass, pass2))
                {
                    var client = new HttpClient();
                    client.BaseAddress = new Uri("http://yazlab1p1api20211026003801.azurewebsites.net");
                    HttpResponseMessage response = await client.GetAsync($"api/users/{user}");
                    string result = await response.Content.ReadAsStringAsync();
                    dynamic obj_str = JsonConvert.DeserializeObject(result);
                    string dataName = null;
                    string dataPw = null;
                    int userID = 0;
                    if (obj_str.Count > 0)
                    {
                        dataName = obj_str[0].userName;
                        dataPw = obj_str[0].userPw;
                        userID = obj_str[0].userID;
                    }
                    if (dataName != null)
                    {
                        var client2 = new RestClient("https://yazlab1p1api20211026003801.azurewebsites.net/api/users");
                        client2.Timeout = -1;
                        var request = new RestRequest(Method.PUT);
                        request.AddHeader("Content-Type", "application/json");
                        request.AddHeader("Cookie", "ARRAffinity=92ca53ad8db4fbb93d4d3b7d8ab54dcf8ffecb2d731f25b0e91ad575d7534c3f; ARRAffinitySameSite=92ca53ad8db4fbb93d4d3b7d8ab54dcf8ffecb2d731f25b0e91ad575d7534c3f");
                        JObject body = new JObject();
                        body["userID"] = userID;
                        body["userName"] = user;
                        body["userPw"] = pass;
                        request.AddParameter("application/json", body, ParameterType.RequestBody);
                        IRestResponse response2 = client2.Execute(request);
                        MessageBox.Show($"Şifreniz başarıyla değiştirildi.");
                        changePassPanel.Hide();
                        loginPanel.Show();
                    }
                    else
                    {
                        MessageBox.Show($"{user} isimli kullanıcı sistemde bulunamadı!");
                    }
                }
                else
                {
                    MessageBox.Show("Şifreler uyuşmamakta!");
                }
            }
            


        }
        //Kargo Takip Paneli

        //Basıldığında login paneline geri döner
        private void buttonCargoTrackPanBack_Click(object sender, EventArgs e)
        {
            cargoTrackingPanel.Hide();
            userPanel.Show();
        }
        //Basıldığında ilgili kargo işlemi iptal edilir
        private async void buttonCargoTrackingCancelCargo_Click(object sender, EventArgs e)
        {
            try
            {
                
                DataGridViewRow row = this.dataGridView1.SelectedRows[0];
                int cellValue = Convert.ToInt32(row.Cells["kargoID"].Value);
                double delLng = Convert.ToDouble(row.Cells["MusteriLocationLng"].Value);
                double delLat = Convert.ToDouble(row.Cells["MusteriLocationLat"].Value);
                Console.WriteLine(row.Cells["MusteriLocationLng"].Value+" "+ row.Cells["MusteriLocationLat"].Value);
                var client = new RestClient();
                var baseURL = "https://yazlab1p1api20211026003801.azurewebsites.net/api/deliveries";
                var apiURL = baseURL + "/" + cellValue;
                client = new RestClient(apiURL);
                client.Timeout = -1;
                var request = new RestRequest(Method.DELETE);
                IRestResponse response = client.Execute(request);
                Console.WriteLine(response.Content);
                MessageBox.Show($"{cellValue} numaralı kargo sistemden silindi!");

                HttpClient clientt = new HttpClient();
                clientt.BaseAddress = new Uri("http://yazlab1p1api20211026003801.azurewebsites.net");
                HttpResponseMessage responsee = clientt.GetAsync("api/deliveries").Result;
                var test = responsee.Content.ReadAsAsync<IEnumerable<Deliveries>>().Result;
                dataGridView1.DataSource = test;

                delivered.Clear();
                formGlob.minDs = 0;
                var clientdeli = new HttpClient();
                clientdeli.BaseAddress = new Uri("http://yazlab1p1api20211026003801.azurewebsites.net");
                HttpResponseMessage responses = await clientdeli.GetAsync("api/deliveries");
                string result = await responses.Content.ReadAsStringAsync();
                dynamic obj_str = JsonConvert.DeserializeObject(result);
                int ids = 0;
                List<Node> nodelists = new List<Node>();
                Node nkullanici = new Node();
                nkullanici.id = ids;
                PointLatLng reg1 = new PointLatLng();
                reg1.Lat = Convert.ToDouble(kullaniciLat);
                reg1.Lng = Convert.ToDouble(kullaniciLng);
                nkullanici.point = reg1;
                nkullanici.isUser = true;
                if (lastDel.point.Lng==delLng && lastDel.point.Lat == delLat)
                {
                    lastDel.id = -1;
                }
                if (lastDel.id == 0)
                {
                    nodelists.Add(lastDel);
                }
                else
                {
                    
                    nodelists.Add(nkullanici);
                }
                ids++;
                foreach (var i in obj_str)
                {
                    //Console.WriteLine(i.MusteriLocationLng + "-" + i.MusteriLocationLat);
                    Node n = new Node();
                    n.id = ids;
                    PointLatLng reg2 = new PointLatLng();
                    reg2.Lat = Convert.ToDouble(i.MusteriLocationLat);
                    reg2.Lng = Convert.ToDouble(i.MusteriLocationLng);
                    n.point = reg2;
                    if (i.MusteriTeslim == "edildi")
                    {
                        delivered.Add(n);
                    }
                    else
                    {
                        nodelists.Add(n);
                    }
                    ids++;
                }
                Thread thread = new Thread(t =>
                {
                    formGlob.cargoRoute(nodelists, delivered,nkullanici, pDel);
                })
                { IsBackground = true };
                thread.Start();


            }

            catch
            {
                MessageBox.Show("Lütfen bir satır seçin.");
            }
            
        }

        //Kargo ekleme paneli işlemleri

        //Login panelinde geri döner
        private void buttonCreateCargoPanBack_Click(object sender, EventArgs e)
        {
            createCargoPanel.Hide();
            userPanel.Show();
        }
        //Basıldığında yeni kargo ekler
        private async void buttonCreateCargoPanCargoAppend_Click(object sender, EventArgs e)
        {
            string customerName = createCargoPanCustomerName.Text;
            string customerAdress = createCargoPanCustomerAdress.Text;
            createCargoPanMap.Overlays.Clear();
            //createCargoPanCustomerAdress.Text ' e girilen adrese göre kargo ekler
            if (String.IsNullOrEmpty(customerName) || String.IsNullOrEmpty(customerAdress))
            {
                MessageBox.Show("İsim ve adres kısmı boş olamaz!");
            }
            else
            {
                if (enAdress.Checked == false)
                {
                    createCargoPanMap.SetPositionByKeywords(createCargoPanCustomerAdress.Text);
                    var center = createCargoPanMap.Position;
                    var centerLng = center.Lng;
                    var centerLat = center.Lat;
                    var markers = new GMapOverlay("markers");
                    var marker = new GMarkerGoogle(center, GMarkerGoogleType.red);
                    markers.Markers.Add(marker);
                    createCargoPanMap.Overlays.Add(markers);
                    var addresses = GetAddress(center);
                    createCargoPanCustomerAdress.Text = "" + String.Join(", ", addresses.ToArray()[0]);
                  
                    var client = new RestClient("https://yazlab1p1api20211026003801.azurewebsites.net/api/deliveries");
                    client.Timeout = -1;
                    var request = new RestRequest(Method.POST);
                    request.AddHeader("Content-Type", "application/json");
                    request.AddHeader("Cookie", "ARRAffinity=92ca53ad8db4fbb93d4d3b7d8ab54dcf8ffecb2d731f25b0e91ad575d7534c3f; ARRAffinitySameSite=92ca53ad8db4fbb93d4d3b7d8ab54dcf8ffecb2d731f25b0e91ad575d7534c3f");
                    JObject body = new JObject();
                    body["MusteriAdi"] = customerName;
                    body["MusteriLokasyon"] = customerAdress;
                    body["MusteriLocationLng"] = centerLng;
                    body["MusteriLocationLat"] = centerLat;
                    request.AddParameter("application/json", body, ParameterType.RequestBody);
                    IRestResponse response = client.Execute(request);
                    MessageBox.Show("Kargo sisteme başarıyla eklendi.");
                }
                //Haritadaki konuma göre kargo ekler
                else
                {
                    createCargoPanMap.SetPositionByKeywords(createCargoPanCustomerAdress.Text);
                    var center = createCargoPanMap.Position;
                    var centerLng = center.Lng;
                    var centerLat = center.Lat;

                    var client = new RestClient("https://yazlab1p1api20211026003801.azurewebsites.net/api/deliveries");
                    client.Timeout = -1;
                    var request = new RestRequest(Method.POST);
                    request.AddHeader("Content-Type", "application/json");
                    request.AddHeader("Cookie", "ARRAffinity=92ca53ad8db4fbb93d4d3b7d8ab54dcf8ffecb2d731f25b0e91ad575d7534c3f; ARRAffinitySameSite=92ca53ad8db4fbb93d4d3b7d8ab54dcf8ffecb2d731f25b0e91ad575d7534c3f");
                    JObject body = new JObject();
                    body["MusteriAdi"] = customerName;
                    body["MusteriLokasyon"] = customerAdress;
                    body["MusteriLocationLng"] = centerLng;
                    body["MusteriLocationLat"] = centerLat;
                    request.AddParameter("application/json", body, ParameterType.RequestBody);
                    IRestResponse response = client.Execute(request);
                    MessageBox.Show("Kargo sisteme başarıyla eklendi.");

                }
                id++;
                if (formGlob != null)
                {
                    delivered.Clear();
                    formGlob.minDs = 0;

                    var clientdeli = new HttpClient();
                    clientdeli.BaseAddress = new Uri("http://yazlab1p1api20211026003801.azurewebsites.net");
                    HttpResponseMessage response = await clientdeli.GetAsync("api/deliveries");
                    string result = await response.Content.ReadAsStringAsync();
                    dynamic obj_str = JsonConvert.DeserializeObject(result);
                    int ids = 0;
                    List<Node> nodelists = new List<Node>();
                    Node nkullanici = new Node();
                    nkullanici.id = ids;
                    PointLatLng reg1 = new PointLatLng();
                    reg1.Lat = Convert.ToDouble(kullaniciLat);
                    reg1.Lng = Convert.ToDouble(kullaniciLng);
                    nkullanici.point = reg1;
                    nkullanici.isUser = true;
                    if (lastDel.id == 0)
                    {
                        nodelists.Add(lastDel);
                    }
                    else
                    {
                        nodelists.Add(nkullanici);
                    }
                    ids++;
                    foreach (var i in obj_str)
                    {
                        //Console.WriteLine(i.MusteriLocationLng + "-" + i.MusteriLocationLat);
                        Node n = new Node();
                        n.id = ids;
                        PointLatLng reg2 = new PointLatLng();
                        reg2.Lat = Convert.ToDouble(i.MusteriLocationLat);
                        reg2.Lng = Convert.ToDouble(i.MusteriLocationLng);
                        n.point = reg2;
                        if (i.MusteriTeslim == "edildi")
                        {
                            delivered.Add(n);
                        }
                        else
                        {
                            nodelists.Add(n);
                        }
                        ids++;
                    }

                   
                    Thread thread = new Thread(t =>
                    {
                        formGlob.cargoRoute(nodelists, delivered,nkullanici, pDel);
                    })
                    { IsBackground = true };
                    thread.Start();
                }
            }
            
            
        }
        //Haritada tıkladığımız noktanın koordinatını alır
        private void createCargoPanMap_MouseClick(object sender, MouseEventArgs e)
        {
            
            if (e.Button == MouseButtons.Left)
            {
                createCargoPanMap.Overlays.Clear();
                var point=createCargoPanMap.FromLocalToLatLng(e.X, e.Y);
                createCargoPanMap.Position = point;
                var markers = new GMapOverlay("markers");
                var marker = new GMarkerGoogle(point, GMarkerGoogleType.red);
                markers.Markers.Add(marker);
                createCargoPanMap.Overlays.Add(markers);
                var addresses=GetAddress(point);
                createCargoPanCustomerAdress.Text = "" + String.Join(", ", addresses.ToArray()[0]);
                
            }
        }

        private List<String> GetAddress(PointLatLng point)
        {
            List<Placemark> placemarks = null;
            var statusCode= GMapProviders.GoogleMap.GetPlacemarks(point,out placemarks);
            if(statusCode == GeoCoderStatusCode.OK && placemarks != null)
            {
                List<String> addresses = new List<string>();
                foreach(var placemark in placemarks)
                {
                    addresses.Add(placemark.Address);
                }
                return addresses;
            }
            return null;
        }
        //Eğer true ise mapten seçim yapılması gerekir false ise text girilmesi gerekir
        private void enAdress_CheckedChanged(object sender, EventArgs e)
        {
            if(createCargoPanCustomerAdress.Enabled == false)
            {
                createCargoPanCustomerAdress.Enabled = true;
                enAdress.Text = "Adres Girişini Devre Dışı Bırak";
            }
            else
            {
                createCargoPanCustomerAdress.Enabled = false;
                createCargoPanCustomerAdress.Text = "";
                enAdress.Text = "Adres Girişini Aktif Et";
            }
        }
        //Kullanıcı konumu eklemek istendiğinde haritadan tıklanan noktanın koordinatını alırr
        private void registerPanNewUserMap_MouseClick(object sender, MouseEventArgs e)
        {
            if (e.Button == MouseButtons.Left)
            {
                registerPanNewUserMap.Overlays.Clear();
                var point = registerPanNewUserMap.FromLocalToLatLng(e.X, e.Y);
                registerPanNewUserMap.Position = point;
                var markers = new GMapOverlay("markers");
                var marker = new GMarkerGoogle(point, GMarkerGoogleType.red);
                markers.Markers.Add(marker);
                registerPanNewUserMap.Overlays.Add(markers);
                var addresses = GetAddress(point);
                registerPanNewUserLocation.Text = "" + String.Join(", ", addresses.ToArray()[0]);
                reg = point;
                
            }
        }
        //Teslim edildi butonu
        private async void buttonCargoTrackingEnableCargo_Click(object sender, EventArgs e)
        {
            try
            {
                DataGridViewRow row = this.dataGridView1.SelectedRows[0];
                int cellValue = Convert.ToInt32(row.Cells["kargoID"].Value);
                double MusteriLocationLng = Convert.ToDouble(row.Cells["MusteriLocationLng"].Value);
                double MusteriLocationLat = Convert.ToDouble(row.Cells["MusteriLocationLat"].Value);
                lastDel.id = 0;
                lastDel.point.Lat = MusteriLocationLat;
                lastDel.point.Lng = MusteriLocationLng;
                string user = changePassPanUserName.Text;
                string pass =loginPanUserPass.Text;
                var client = new RestClient();
                string baseURL = "https://yazlab1p1api20211026003801.azurewebsites.net/api/deliveries";
                string apiURL = baseURL + "/" + Convert.ToString(cellValue);
                client = new RestClient(apiURL);
                client.Timeout = -1;
                var request = new RestRequest(Method.PUT);
                IRestResponse response = client.Execute(request);
                MessageBox.Show($"{cellValue} numaralı kargo teslim edildi olarak güncellendi!");              

                HttpClient clientt = new HttpClient();
                clientt.BaseAddress = new Uri("http://yazlab1p1api20211026003801.azurewebsites.net");
                HttpResponseMessage responsee = clientt.GetAsync("api/deliveries").Result;
                var test = responsee.Content.ReadAsAsync<IEnumerable<Deliveries>>().Result;
                dataGridView1.DataSource = test;
            }
            catch
            {
                MessageBox.Show("Lütfen bir satır seçin.");
            }
            if (delivered != null) {
                delivered.Clear();
                formGlob.minDs = 0;
                var clientdeli = new HttpClient();
                clientdeli.BaseAddress = new Uri("http://yazlab1p1api20211026003801.azurewebsites.net");
                HttpResponseMessage response = await clientdeli.GetAsync("api/deliveries");
                string result = await response.Content.ReadAsStringAsync();
                dynamic obj_str = JsonConvert.DeserializeObject(result);
                int ids = 0;
                List<Node> nodelists = new List<Node>();
                Node nkullanici = new Node();
                nkullanici.id = ids;
                PointLatLng reg1 = new PointLatLng();
                reg1.Lat = Convert.ToDouble(kullaniciLat);
                reg1.Lng = Convert.ToDouble(kullaniciLng);
                nkullanici.point = reg1;
                nkullanici.isUser = true;
                if (lastDel.id==0)
                {
                    nodelists.Add(lastDel);
                }
                else
                {
                    
                    nodelists.Add(nkullanici);
                }
                ids++;
                foreach (var i in obj_str)
                {
                    //Console.WriteLine(i.MusteriLocationLng + "-" + i.MusteriLocationLat);
                    Node n = new Node();
                    n.id = ids;
                    PointLatLng reg2 = new PointLatLng();
                    reg2.Lat = Convert.ToDouble(i.MusteriLocationLat);
                    reg2.Lng = Convert.ToDouble(i.MusteriLocationLng);
                    n.point = reg2;
                    if (i.MusteriTeslim == "edildi")
                    {
                        delivered.Add(n);
                    }
                    else
                    {
                        nodelists.Add(n);
                    }
                    ids++;
                }
                Thread thread = new Thread(t =>
                {
                    formGlob.cargoRoute(nodelists, delivered, nkullanici, pDel);
                })
                { IsBackground = true };
                thread.Start();
            }
            
        }
    }
}
