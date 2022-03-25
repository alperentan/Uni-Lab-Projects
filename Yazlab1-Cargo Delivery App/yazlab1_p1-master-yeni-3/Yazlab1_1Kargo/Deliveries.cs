using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Yazlab1_1Kargo
{
    class Deliveries
    {
        public int kargoID { get; set; }

        public string MusteriAdi { get; set; }

        public string MusteriLokasyon { get; set; }
        
        public double MusteriLocationLng { get; set; }

        public double MusteriLocationLat { get; set; }

        public string MusteriTeslim { get; set; }
    }
}
