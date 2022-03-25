using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using GMap.NET;
using GMap.NET.MapProviders;
using GMap.NET.WindowsForms;
using GMap.NET.WindowsForms.Markers;
namespace Yazlab1_1Kargo
{
    public class Node
    {
        public int id;
        public PointLatLng point = new PointLatLng();
        public List<NodeNegh> neghs = new List<NodeNegh>();
        public bool isUser = false;
        public bool isDelivered = false;
    }
}
