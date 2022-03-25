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
namespace Yazlab1_1Kargo
{

    public partial class Form2 : Form
    {
        public List<Node> allNode = new List<Node>();
        public List<Node> allNodeForPer = new List<Node>();
        public List<Node> comp = new List<Node>();
        public Node user = new Node();
        public List<Node> path = new List<Node>();
        public List<PointLatLng> deliverPoint = new List<PointLatLng>();
        Node fs = new Node();

        public double minDs = 0;
        public Form2()
        {
            InitializeComponent();
            trackingCourierPanelMap.CacheLocation = @"cache";
            trackingCourierPanelMap.DragButton = MouseButtons.Right;
            trackingCourierPanelMap.MapProvider = GMapProviders.GoogleMap;
            trackingCourierPanelMap.ShowCenter = false;
            trackingCourierPanelMap.MinZoom = 5;
            trackingCourierPanelMap.MaxZoom = 100;
            trackingCourierPanelMap.Zoom = 15;
            trackingCourierPanelMap.SetPositionByKeywords("Kocaeli, Türkiye");
        }

        public void cargoRoute(List<Node> nd, List<Node> vs ,Node us, List<PointLatLng> del)
        {
            allNodeForPer.Clear();
            allNode = nd;
            comp = vs;
            user = us;
            deliverPoint = del;
            foreach (var i in allNode)
            {
                allNodeForPer.Add(i);
            }
            setNegh();
            try
            {
                fs = allNode[0];
                
            }
            catch (Exception e)
            {
                MessageBox.Show("Kargo Mevcut Değildir");
            }
            travellingSalesman(allNodeForPer, allNodeForPer.Count, allNodeForPer.Count);
            getRoute();
        }
        //Harita üzerinde rotayı alır
        public void getRoute()
        {
            try { 
            trackingCourierPanelMap.Overlays.Clear();
                foreach (var j in deliverPoint)
                {
                    Console.WriteLine(j.Lat + " " + j.Lng);
                    var markers = new GMapOverlay("markers");
                    GMapMarker marker = new GMarkerGoogle(j, GMarkerGoogleType.blue_dot);
                    markers.Markers.Add(marker);
                    trackingCourierPanelMap.Overlays.Add(markers);
                }
                for (int i = 0; i < path.Count - 1; i++)
            {
                var markers = new GMapOverlay("markers");
                GMapMarker marker= new GMarkerGoogle(path[i].point, GMarkerGoogleType.red_dot); 
                if (path[i].isUser == true)
                {
                    marker = new GMarkerGoogle(path[i].point, GMarkerGoogleType.green_dot);
                } 
                
                markers.Markers.Add(marker);
                trackingCourierPanelMap.Overlays.Add(markers);

                var route = GoogleMapProvider.Instance.GetRoute(path[i].point, path[i + 1].point, false, false, 15);
                var r = new GMapRoute(route.Points, "DenemeRota");
                var routes = new GMapOverlay("routes");
                routes.Routes.Add(r);
                trackingCourierPanelMap.Overlays.Add(routes);
            }
            var marks = new GMapOverlay("markers");
            GMapMarker markr = new GMarkerGoogle(path[path.Count-1].point, GMarkerGoogleType.red_dot);
            marks.Markers.Add(markr);
            trackingCourierPanelMap.Overlays.Add(marks);
                foreach ( var j in comp)
                {
                    var markers = new GMapOverlay("markers");
                    GMapMarker marker = new GMarkerGoogle(j.point, GMarkerGoogleType.yellow_dot);
                    markers.Markers.Add(marker);
                    trackingCourierPanelMap.Overlays.Add(markers);
                }
                var markersus = new GMapOverlay("markers");
                GMapMarker markerus = new GMarkerGoogle(user.point, GMarkerGoogleType.green_dot);
                markersus.Markers.Add(markerus);
                trackingCourierPanelMap.Overlays.Add(markersus);
                
            }
            catch(Exception e)
            {
                Console.WriteLine("Hata");
            }

        }
        //Noktaların komşusunu alır
        public void setNegh()
        {
            foreach (var i in allNode)
            {
                foreach (var j in allNode)
                {
                    if (j == i)
                    {
                        continue;
                    }
                    else
                    {
                        var route = GoogleMapProvider.Instance.GetRoute(i.point, j.point, false, false, 15);
                        NodeNegh newNegh = new NodeNegh();
                        newNegh.len = route.Distance;
                        newNegh.neg = j;
                        i.neghs.Add(newNegh);
                    }
                }
            }
        }
        //En kısa yolu alır
        public void getMin(List<Node> a, int n)
        {
            double dis = 0;
            List<Node> proccess = new List<Node>();
            proccess.Add(fs);
            for (int i = 0; i < n; i++)
            {
                proccess.Add(a[i]);
            }
            for (int i = 0; i < n; i++)
            {
                foreach (var j in proccess[i].neghs)
                {
                    if (j.neg.id == proccess[i + 1].id)
                    {
                        dis += j.len;
                    }
                }
            }


            if (minDs == 0 || dis < minDs)
            {
                path = proccess;
                minDs = dis;
            }


        }
        //Gezgin satıcı problemini çalıştırır
        public void travellingSalesman(List<Node> a, int size, int n)
        {
            if (size == 1)
                getMin(a, n);

            for (int i = 0; i < size; i++)
            {
                travellingSalesman(a, size - 1, n);

                if (size % 2 == 1)
                {
                    Node temp = a[0];
                    a[0] = a[size - 1];
                    a[size - 1] = temp;
                }

                else
                {
                    Node temp = a[i];
                    a[i] = a[size - 1];
                    a[size - 1] = temp;
                }
            }
        }



    }
}
