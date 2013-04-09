using System;
using System.Collections.Generic;
using System.Text;
using HIDLibrary;
using System.Threading;

namespace USBScaleView
{
    public static class USBScale
    {
        public static HidDeviceData inData;
        private static HidDevice[] hidDeviceList;
        private static HidDevice scaleDevice;

        private static double totalOunces = 0;
        public static double TotalOunces
        {
            get
            {
                return totalOunces;
            }
        }

        private static double grams = 0.0;
        public static double Grams
        {
            get
            {
                return grams;
            }
        }

        private static double ounces = 0;
        public static double Ounces
        {
            get
            {
                return ounces;
            }
        }

        private static int pounds = 0;
        public static int Pounds
        {
            get
            {
                return pounds;
            }
        }

        public enum ScaleStatus
        {
            FAULT = 1, STABLE_AT_ZERO = 2, IN_MOTION = 3, STABLE = 4, UNDER_ZERO = 5, OVER_WEIGHT = 6, NEEDS_CALIBRATE = 7, NEEDS_REZERO = 8
        }

        private static int status;
        public static int Status
        {
            get
            {
                return status;
            }
        }

        public static bool IsConnected
        {
            get
            {
                if (scaleDevice == null)
                    return false;
                else
                    return scaleDevice.IsConnected;
            }
        }

        public static void GetWeight()
        {

            if (scaleDevice.IsConnected)
            {
                inData = scaleDevice.Read(250);

                status = inData.Data[1];

                totalOunces = (Convert.ToDouble(inData.Data[4]) + Convert.ToDouble(inData.Data[5]) * 256) / 10;

            }

            ounces = Math.Round(totalOunces % 16.0, 1);
            pounds = (int)(Math.Floor(totalOunces) / 16.0);
            grams = Math.Round(totalOunces * 28.3495231, 1);

        }

        public static void InitDevice()
        {
            hidDeviceList = HidDevices.Enumerate(0x1446, 0x6A73);

            if (hidDeviceList.Length > 0)
            {
                int waitTries;

                scaleDevice = hidDeviceList[0];
                waitTries = 0;

                scaleDevice.Open();
                // For some reason, the scale isn't always immediately available
                // after calling Open(). Let's wait for a few milliseconds before
                // giving up.
                while (!scaleDevice.IsConnected && waitTries < 10)
                {
                    Thread.Sleep(10);
                    waitTries++;
                }
            }

        }

        public static void TareScale()
        {
            if (scaleDevice != null)
            {
                if (scaleDevice.IsConnected)
                {
                    HidReport report = scaleDevice.CreateReport();

                    report.ReportId = 2;
                    report.Data[0] = 2;
                    scaleDevice.WriteReport(report);

                }
            }
        }

    }
}
