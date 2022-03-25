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

    public class deliveriesController : ControllerBase
    {
        private readonly IConfiguration _configuration;
        public deliveriesController(IConfiguration configuration)
        {
            _configuration = configuration;
        }

        [HttpGet("{name}")]
        public JsonResult Get(String name)
        {
            string query = @"
                        SELECT kargoID,MusteriAdi,MusteriLokasyon,MusteriLocationLng,MusteriLocationLat,MusteriTeslim from 
                        yazlab1proje1db.deliveries WHERE (MusteriLokasyon = @MusteriLokasyon);
        ";
            DataTable table = new DataTable();
            string sqlDataSource = _configuration.GetConnectionString("yazlab1proje1dbAppCon");
            MySqlDataReader myReader;
            using (MySqlConnection mycon = new MySqlConnection(sqlDataSource))
            {
                mycon.Open();
                using (MySqlCommand myCommand = new MySqlCommand(query, mycon))
                {
                    myCommand.Parameters.AddWithValue("@MusteriLokasyon", name);
                    myReader = myCommand.ExecuteReader();
                    table.Load(myReader);

                    myReader.Close();
                    mycon.Close();
                }
            }
            return new JsonResult(table);
        }

        [HttpGet]
        public JsonResult Get2(String name)
        {
            string query = @"
                        SELECT kargoID,MusteriAdi,MusteriLokasyon,MusteriLocationLng,MusteriLocationLat,MusteriTeslim from 
                        yazlab1proje1db.deliveries
        ";
            DataTable table = new DataTable();
            string sqlDataSource = _configuration.GetConnectionString("yazlab1proje1dbAppCon");
            MySqlDataReader myReader;
            using (MySqlConnection mycon = new MySqlConnection(sqlDataSource))
            {
                mycon.Open();
                using (MySqlCommand myCommand = new MySqlCommand(query, mycon))
                {
                    myCommand.Parameters.AddWithValue("@MusteriLokasyon", name);
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
                        INSERT INTO yazlab1proje1db.deliveries (MusteriAdi, MusteriLokasyon, MusteriLocationLng,  MusteriLocationLat) VALUES (@MusteriAdi, @MusteriLokasyon, @MusteriLocationLng, @MusteriLocationLat);
                        
        ";
            DataTable table = new DataTable();
            string sqlDataSource = _configuration.GetConnectionString("yazlab1proje1dbAppCon");
            MySqlDataReader myReader;
            using (MySqlConnection mycon = new MySqlConnection(sqlDataSource))
            {
                mycon.Open();
                using (MySqlCommand myCommand = new MySqlCommand(query, mycon))
                {
                    myCommand.Parameters.AddWithValue("@MusteriAdi", ylp.MusteriAdi);
                    myCommand.Parameters.AddWithValue("@MusteriLokasyon", ylp.MusteriLokasyon);
                    myCommand.Parameters.AddWithValue("@MusteriLocationLng", ylp.MusteriLocationLng);
                    myCommand.Parameters.AddWithValue("@MusteriLocationLat", ylp.MusteriLocationLat);
                    myReader = myCommand.ExecuteReader();
                    table.Load(myReader);

                    myReader.Close();
                    mycon.Close();
                }
            }
            return new JsonResult("Added Successfully");
        }

        [HttpPut("{id}")]
        public JsonResult PutID(int id)
        {
            string query = @"
                        UPDATE yazlab1proje1db.deliveries SET MusteriTeslim = 'edildi' WHERE (kargoID = @kargoID);
                        
        ";
            DataTable table = new DataTable();
            string sqlDataSource = _configuration.GetConnectionString("yazlab1proje1dbAppCon");
            MySqlDataReader myReader;
            using (MySqlConnection mycon = new MySqlConnection(sqlDataSource))
            {
                mycon.Open();
                using (MySqlCommand myCommand = new MySqlCommand(query, mycon))
                {
                    myCommand.Parameters.AddWithValue("@kargoID", id);
                    myReader = myCommand.ExecuteReader();
                    table.Load(myReader);

                    myReader.Close();
                    mycon.Close();
                }
            }
            return new JsonResult("Updated Successfully");
        }

        [HttpPut]
        public JsonResult Put(yazlab1proje1db ylp)
        {
            string query = @"
                       UPDATE yazlab1proje1db.deliveries SET MusteriAdi = @MusteriAdi, MusteriLokasyon = @MusteriLokasyon, MusteriLocationLng = @MusteriLocationLng, MusteriLocationLat = @MusteriLocationLat, MusteriTeslim = @MusteriTeslim WHERE (MusteriAdi = @MusteriAdi);
                        
        ";
            DataTable table = new DataTable();
            string sqlDataSource = _configuration.GetConnectionString("yazlab1proje1dbAppCon");
            MySqlDataReader myReader;
            using (MySqlConnection mycon = new MySqlConnection(sqlDataSource))
            {
                mycon.Open();
                using (MySqlCommand myCommand = new MySqlCommand(query, mycon))
                {
                    myCommand.Parameters.AddWithValue("@MusteriAdi", ylp.MusteriAdi);
                    myCommand.Parameters.AddWithValue("@MusteriLokasyon", ylp.MusteriLokasyon);
                    myCommand.Parameters.AddWithValue("@MusteriLocationLng", ylp.MusteriLocationLng);
                    myCommand.Parameters.AddWithValue("@MusteriLocationLat", ylp.MusteriLocationLat);
                    myCommand.Parameters.AddWithValue("@kargoTeslim", ylp.MusteriTeslim);
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
                        DELETE FROM yazlab1proje1db.deliveries WHERE (kargoID = @kargoID);
                        
        ";
            DataTable table = new DataTable();
            string sqlDataSource = _configuration.GetConnectionString("yazlab1proje1dbAppCon");
            MySqlDataReader myReader;
            using (MySqlConnection mycon = new MySqlConnection(sqlDataSource))
            {
                mycon.Open();
                using (MySqlCommand myCommand = new MySqlCommand(query, mycon))
                {
                    myCommand.Parameters.AddWithValue("@kargoID", id);
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