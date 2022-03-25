using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace yazlab1p1_api.Models
{
    public class yazlab1proje1db
    {
        public int userID { get; set; }
        
        public string userName { get; set; }

        public string userPw { get; set; }

        public int kargoID { get; set; }

        public int MusteriID { get; set; }

        public string MusteriAdi { get; set; }

        public string MusteriLokasyon { get; set; }

        public double MusteriLocationLng { get; set; }

        public double MusteriLocationLat { get; set; }

        public int MusteriTeslim { get; set; }

        public double enlem { get; set; }

        public double boylam { get; set; }

        public int deliveryPointsID { get; set; }

        public string deliveryPointsAdi { get; set; }

        public string deliveryPointsLokasyon { get; set; }

        public double deliveryPointsLocationLng { get; set; }

        public double deliveryPointsLocationLat { get; set; }

        public double userLocationLng { get; set; }

        public double userLocationLat { get; set; }



    }


}
