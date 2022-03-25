using System;
using System.Collections.Generic;
using System.Text;
using System.Windows.Forms;

namespace yazlab1proje2_v1
{
    class SudokuCell : Button
    {
        public int Value { get; set; }
        public bool IsLocked { get; set; }
        public int X { get; set; }
        public int Y { get; set; }

        public double tri { get; set; }

        public void Clear()
        {
            this.Text = string.Empty;
            this.IsLocked = false;
        }
    }
}
