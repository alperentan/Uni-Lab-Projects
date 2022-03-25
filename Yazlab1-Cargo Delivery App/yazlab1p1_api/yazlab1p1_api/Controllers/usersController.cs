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

    public class usersController : ControllerBase
    {
        private readonly IConfiguration _configuration;
        public usersController(IConfiguration configuration)
        {
            _configuration = configuration;
        }

        [HttpGet("{name}")]
        public JsonResult Get(String name)
        {
            string query = @"
                        SELECT userID,userName,userPw,userLocationLng,userLocationLat from 
                        yazlab1proje1db.users WHERE (userName = @userName);
        ";
            DataTable table = new DataTable();
            string sqlDataSource = _configuration.GetConnectionString("yazlab1proje1dbAppCon");
            MySqlDataReader myReader;
            using (MySqlConnection mycon = new MySqlConnection(sqlDataSource))
            {
                mycon.Open();
                using (MySqlCommand myCommand = new MySqlCommand(query, mycon))
                {
                    myCommand.Parameters.AddWithValue("@userName", name);
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
                        INSERT INTO yazlab1proje1db.users (userName, userPw, userLocationLng, userLocationLat) VALUES (@userName, @userPw, @userLocationLng, @userLocationLat);
                        
        ";
            DataTable table = new DataTable();
            string sqlDataSource = _configuration.GetConnectionString("yazlab1proje1dbAppCon");
            MySqlDataReader myReader;
            using (MySqlConnection mycon = new MySqlConnection(sqlDataSource))
            {
                mycon.Open();
                using (MySqlCommand myCommand = new MySqlCommand(query, mycon))
                {
                    myCommand.Parameters.AddWithValue("@userName", ylp.userName);
                    myCommand.Parameters.AddWithValue("@userPw", ylp.userPw);
                    myCommand.Parameters.AddWithValue("@userLocationLng", ylp.userLocationLng);
                    myCommand.Parameters.AddWithValue("@userLocationLat", ylp.userLocationLat);
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
                        UPDATE yazlab1proje1db.users SET userName = @userName, userPw = @userPw, userLocationLng=@userLocationLng, userLocationLat=@userLocationLat WHERE (userID = @userID);
                        
        ";
            DataTable table = new DataTable();
            string sqlDataSource = _configuration.GetConnectionString("yazlab1proje1dbAppCon");
            MySqlDataReader myReader;
            using (MySqlConnection mycon = new MySqlConnection(sqlDataSource))
            {
                mycon.Open();
                using (MySqlCommand myCommand = new MySqlCommand(query, mycon))
                {
                    myCommand.Parameters.AddWithValue("@userID", ylp.userID);
                    myCommand.Parameters.AddWithValue("@userName", ylp.userName);
                    myCommand.Parameters.AddWithValue("@userPw", ylp.userPw);
                    myCommand.Parameters.AddWithValue("@userLocationLng", ylp.userLocationLng);
                    myCommand.Parameters.AddWithValue("@userLocationLat", ylp.userLocationLat);
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
                        DELETE FROM yazlab1proje1db.users WHERE (userID = @userID);
                        
        ";
            DataTable table = new DataTable();
            string sqlDataSource = _configuration.GetConnectionString("yazlab1proje1dbAppCon");
            MySqlDataReader myReader;
            using (MySqlConnection mycon = new MySqlConnection(sqlDataSource))
            {
                mycon.Open();
                using (MySqlCommand myCommand = new MySqlCommand(query, mycon))
                {
                    myCommand.Parameters.AddWithValue("@userID", id);
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