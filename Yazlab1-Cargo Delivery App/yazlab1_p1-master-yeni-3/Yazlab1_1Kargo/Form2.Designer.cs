
namespace Yazlab1_1Kargo
{
    partial class Form2
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.trackingCourierPanel = new System.Windows.Forms.Panel();
            this.trackingCourierPanelMap = new GMap.NET.WindowsForms.GMapControl();
            this.trackingCourierPanel.SuspendLayout();
            this.SuspendLayout();
            // 
            // trackingCourierPanel
            // 
            this.trackingCourierPanel.Controls.Add(this.trackingCourierPanelMap);
            this.trackingCourierPanel.Location = new System.Drawing.Point(12, 12);
            this.trackingCourierPanel.Name = "trackingCourierPanel";
            this.trackingCourierPanel.Size = new System.Drawing.Size(776, 426);
            this.trackingCourierPanel.TabIndex = 0;
            // 
            // trackingCourierPanelMap
            // 
            this.trackingCourierPanelMap.Bearing = 0F;
            this.trackingCourierPanelMap.CanDragMap = true;
            this.trackingCourierPanelMap.EmptyTileColor = System.Drawing.Color.Navy;
            this.trackingCourierPanelMap.GrayScaleMode = false;
            this.trackingCourierPanelMap.HelperLineOption = GMap.NET.WindowsForms.HelperLineOptions.DontShow;
            this.trackingCourierPanelMap.LevelsKeepInMemory = 5;
            this.trackingCourierPanelMap.Location = new System.Drawing.Point(3, 3);
            this.trackingCourierPanelMap.MarkersEnabled = true;
            this.trackingCourierPanelMap.MaxZoom = 2;
            this.trackingCourierPanelMap.MinZoom = 2;
            this.trackingCourierPanelMap.MouseWheelZoomEnabled = true;
            this.trackingCourierPanelMap.MouseWheelZoomType = GMap.NET.MouseWheelZoomType.MousePositionAndCenter;
            this.trackingCourierPanelMap.Name = "trackingCourierPanelMap";
            this.trackingCourierPanelMap.NegativeMode = false;
            this.trackingCourierPanelMap.PolygonsEnabled = true;
            this.trackingCourierPanelMap.RetryLoadTile = 0;
            this.trackingCourierPanelMap.RoutesEnabled = true;
            this.trackingCourierPanelMap.ScaleMode = GMap.NET.WindowsForms.ScaleModes.Integer;
            this.trackingCourierPanelMap.SelectedAreaFillColor = System.Drawing.Color.FromArgb(((int)(((byte)(33)))), ((int)(((byte)(65)))), ((int)(((byte)(105)))), ((int)(((byte)(225)))));
            this.trackingCourierPanelMap.ShowTileGridLines = false;
            this.trackingCourierPanelMap.Size = new System.Drawing.Size(770, 423);
            this.trackingCourierPanelMap.TabIndex = 0;
            this.trackingCourierPanelMap.Zoom = 0D;
            // 
            // Form2
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.trackingCourierPanel);
            this.Name = "Form2";
            this.Text = "Form2";
            this.trackingCourierPanel.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Panel trackingCourierPanel;
        private GMap.NET.WindowsForms.GMapControl trackingCourierPanelMap;
    }
}