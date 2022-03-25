using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Configuration;
using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Threading.Tasks;
using yazlab1p1_api.Models;

namespace yazlab1p1_api.Controllers
{
    [Route("api/[controller]")]
    [ApiController]

    public class deliveryPointsController : ControllerBase
    {
        private readonly IConfiguration _configuration;
        public deliveryPointsController(IConfiguration configuration)
        {
            _configuration = configuration;
        }

        [HttpGet]
        public JsonResult Get(String name)
        {
            string query = @"
                        SELECT deliveryPointsID,deliveryPointsAdi,deliveryPointsLokasyon,deliveryPointsLocationLng,deliveryPointsLocationLat from 
                        yazlab1proje1db.deliveryPoints
        ";
            DataTable table = new DataTable();
            string sqlDataSource = _configuration.GetConnectionString("yazlab1proje1dbAppCon");
            MySqlDataReader myReader;
            using (MySqlConnection mycon = new MySqlConnection(sqlDataSource))
            {
                mycon.Open();
                using (MySqlCommand myCommand = new MySqlCommand(query, mycon))
                {
                    myCommand.Parameters.AddWithValue("@deliveryPointsAdi", name);
                    myReader = myCommand.ExecuteReader();
                    table.Load(myReader);

                    myReader.Close();
                    mycon.Close();
                }
            }
            return new JsonResult(table);
        }

        [HttpPost]
        public JsonResult Post(yazlab1proje1db ylp)
        {
            string query = @"
                        INSERT INTO yazlab1proje1db.deliveryPoints (deliveryPointsAdi, deliveryPointsLokasyon, deliveryPointsLocationLng, deliveryPointsLocationLat) 
                        VALUES (@deliveryPointsAdi, @deliveryPointsLokasyon, @deliveryPointsLocationLng, @deliveryPointsLocationLat);
                        
        ";
            DataTable table = new DataTable();
            string sqlDataSource = _configuration.GetConnectionString("yazlab1proje1dbAppCon");
            MySqlDataReader myReader;
            using (MySqlConnection mycon = new MySqlConnection(sqlDataSource))
            {
                mycon.Open();
                using (MySqlCommand myCommand = new MySqlCommand(query, mycon))
                {
                    myCommand.Parameters.AddWithValue("@deliveryPointsAdi", ylp.deliveryPointsAdi);
                    myCommand.Parameters.AddWithValue("@deliveryPointsLokasyon", ylp.deliveryPointsLokasyon);
                    myCommand.Parameters.AddWithValue("@deliveryPointsLocationLng", ylp.deliveryPointsLocationLng);
                    myCommand.Parameters.AddWithValue("@deliveryPointsLocationLat", ylp.deliveryPointsLocationLat);
                    myReader = myCommand.ExecuteReader();
                    table.Load(myReader);

                    myReader.Close();
                    mycon.Close();
                }
            }
            return new JsonResult("Added Successfully");
        }

        [HttpPut]
        public JsonResult Put(yazlab1proje1db ylp)
        {
            string query = @"
                       UPDATE yazlab1proje1db.deliveryPoints SET deliveryPointsAdi = @deliveryPointsAdi, deliveryPointsLokasyon = @deliveryPointsLokasyon, deliveryPointsLocationLng = @deliveryPointsLocationLng, deliveryPointsLocationLat = @deliveryPointsLocationLat WHERE (deliveryPointsID = @deliveryPointsID);
                        
        ";
            DataTable table = new DataTable();
            string sqlDataSource = _configuration.GetConnectionString("yazlab1proje1dbAppCon");
            MySqlDataReader myReader;
            using (MySqlConnection mycon = new MySqlConnection(sqlDataSource))
            {
                mycon.Open();
                using (MySqlCommand myCommand = new MySqlCommand(query, mycon))
                {
                    myCommand.Parameters.AddWithValue("@deliveryPointsID", ylp.deliveryPointsID);
                    myCommand.Parameters.AddWithValue("@deliveryPointsAdi", ylp.deliveryPointsAdi);
                    myCommand.Parameters.AddWithValue("@deliveryPointsLokasyon", ylp.deliveryPointsLokasyon);
                    myCommand.Parameters.AddWithValue("@deliveryPointsLocationLng", ylp.deliveryPointsLocationLng);
                    myCommand.Parameters.AddWithValue("@deliveryPointsLocationLat", ylp.deliveryPointsLocationLat);
                    myReader = myCommand.ExecuteReader();
                    table.Load(myReader);

                    myReader.Close();
                    mycon.Close();
                }
            }
            return new JsonResult("Updated Successfully");
        }

        [HttpDelete("{id}")]
        public JsonResult Delete(int id)
        {
            string query = @"
                        DELETE FROM yazlab1proje1db.deliveryPoints WHERE (deliveryPointsID = @deliveryPointsID);
                        
        ";
            DataTable table = new DataTable();
            string sqlDataSource = _configuration.GetConnectionString("yazlab1proje1dbAppCon");
            MySqlDataReader myReader;
            using (MySqlConnection mycon = new MySqlConnection(sqlDataSource))
            {
                mycon.Open();
                using (MySqlCommand myCommand = new MySqlCommand(query, mycon))
                {
                    myCommand.Parameters.AddWithValue("@deliveryPointsID", id);
                    myReader = myCommand.ExecuteReader();
                    table.Load(myReader);

                    myReader.Close();
                    mycon.Close();
                }
            }
            return new JsonResult("Deleted Successfully");
        }
    }
}
