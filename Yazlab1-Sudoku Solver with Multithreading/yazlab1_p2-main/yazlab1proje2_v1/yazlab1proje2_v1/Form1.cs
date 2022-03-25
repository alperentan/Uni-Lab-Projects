using System;
using System.Collections.Generic;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Windows.Forms;

namespace yazlab1proje2_v1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

            createCells();
            
            chart1.Titles.Add("Thread grafigi");
            //Test amacli grafik verileri
            chart1.Series["5 thread"].Points.AddXY("1", "10");
            chart1.Series["5 thread"].Points.AddXY("2", "20");
            chart1.Series["5 thread"].Points.AddXY("3", "30");
            chart1.Series["10 thread"].Points.AddXY("1", "20");
            chart1.Series["10 thread"].Points.AddXY("2", "40");
            chart1.Series["10 thread"].Points.AddXY("3", "50");
        }

        SudokuCell[,] cells = new SudokuCell[21, 21];
        private void createCells()
        {
            for (int i = 0; i < 21; i++)
            {
                for (int j = 0; j < 21; j++)
                {
                    //cizilmeyecek hucreler
                    if (((j == 9) || (j == 10) || (j == 11)) && ((i == 0) || (i == 1) || (i == 2) || (i == 3) || (i == 4) || (i == 5) || (i == 15) || (i == 16) || (i == 17) || (i == 18) || (i == 19) || (i == 20)))
                    {
                    }
                    else if (((i == 9) || (i == 10) || (i == 11)) && ((j == 0) || (j == 1) || (j == 2) || (j == 3) || (j == 4) || (j == 5) || (j == 15) || (j == 16) || (j == 17) || (j == 18) || (j == 19) || (j == 20)))
                    {
                    }
                    else
                    {
                        cells[i, j] = new SudokuCell();
                        cells[i, j].Font = new Font(SystemFonts.DefaultFont.FontFamily, 12);
                        cells[i, j].Size = new Size(30, 30);
                        cells[i, j].ForeColor = SystemColors.ControlDarkDark;
                        cells[i, j].Location = new Point(i * 30, j * 30);
                        //cells[i, j].BackColor = ((i / 3) + (j / 3)) % 2 == 0 ? SystemColors.Control : Color.LightGray;
                        cells[i, j].FlatStyle = FlatStyle.Flat;
                        cells[i, j].FlatAppearance.BorderColor = Color.Black;
                        cells[i, j].X = i;
                        cells[i, j].Y = j;
                        
                        panel1.Controls.Add(cells[i, j]);
                    }

                }
            }
            // karelere sayi ekleme --test amacli--
            cells[0, 1].Value = 1;
            //karelere sayiyi yansitma --test amacli--
            cells[0, 1].Text = cells[0, 1].Value.ToString();
        }
        private void chart1_Click(object sender, EventArgs e)
        {

        }
    }
}
