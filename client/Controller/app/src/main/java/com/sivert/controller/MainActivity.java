package com.sivert.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.view.View.OnTouchListener;

import java.io.*;
import java.net.*;
import android.app.DownloadManager.Request;

public class MainActivity extends AppCompatActivity {
    OnButtonW OnBW;
    OffButtonW OffBW;

    OnButtonS OnBS;
    OffButtonS OffBS;

    OnButtonA OnBA;
    OffButtonA OffBA;

    OnButtonD OnBD;
    OffButtonD OffBD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);
        itemButtonClick();
    }


    private void itemButtonClick() {
        Button up = (Button) findViewById(R.id.w);
        Button down = (Button) findViewById(R.id.s);
        Button left = (Button) findViewById(R.id.a);
        Button right = (Button) findViewById(R.id.d);


        up.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    OnBW = new OnButtonW();
                    OnBW.execute();
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    OffBW = new OffButtonW();
                    OffBW.execute();
                }
                return false;
            }
        });
        down.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    OnBS = new OnButtonS();
                    OnBS.execute();
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    OffBS = new OffButtonS();
                    OffBS.execute();
                }
                return false;
            }
        });
        left.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    OnBA = new OnButtonA();
                    OnBA.execute();
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    OffBA = new OffButtonA();
                    OffBA.execute();
                }
                return false;
            }
        });
        right.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    OnBD = new OnButtonD();
                    OnBD.execute();
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    OffBD = new OffButtonD();
                    OffBD.execute();
                }
                return false;
            }
        });
    }
    private static Socket clientSocket; //сокет для общения
    private static BufferedReader reader; // нам нужен ридер читающий с консоли, иначе как
    // мы узнаем что хочет сказать клиент?
    private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет

    public void Click(View view) {
        Intent intent=new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);
    }


    class OnButtonW extends AsyncTask<Void, Void, Void> {
        int port = 4004;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            int serverPort = 4004;
            String address = "192.168.0.7";

            try {
                InetAddress ipAddress = InetAddress.getByName(address);
                System.out.println("Connecting...");
                clientSocket = new Socket(ipAddress, serverPort);
                System.out.println("Connected\n");
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                out.write("OnButtonW");
                out.flush();
            } catch (Exception x) {
                x.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
        }
    }
    class OffButtonW extends AsyncTask<Void, Void, Void> {
        int port = 4004;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            int serverPort = 4004;
            String address = "192.168.0.7";

            try {
                InetAddress ipAddress = InetAddress.getByName(address);
                System.out.println("Connecting...");
                clientSocket = new Socket(ipAddress, serverPort);
                System.out.println("Connected\n");
                System.out.println("Send mess...");
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                out.write("OffButtonW");
                out.flush();
            } catch (Exception x) {
                x.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
        }
    }

    class OnButtonS extends AsyncTask<Void, Void, Void> {
        int port = 4004;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            int serverPort = 4004;
            String address = "192.168.0.7";

            try {
                InetAddress ipAddress = InetAddress.getByName(address);
                System.out.println("Connecting...");
                clientSocket = new Socket(ipAddress, serverPort);
                System.out.println("Connected\n");
                System.out.println("Send mess...");
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                out.write("OnButtonS");
                out.flush();
            } catch (Exception x) {
                x.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
        }
    }
    class OffButtonS extends AsyncTask<Void, Void, Void> {
        int port = 4004;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            int serverPort = 4004;
            String address = "192.168.0.7";

            try {
                InetAddress ipAddress = InetAddress.getByName(address);
                System.out.println("Connecting...");
                clientSocket = new Socket(ipAddress, serverPort);
                System.out.println("Connected\n");
                System.out.println("Send mess...");
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                out.write("OffButtonS");
                out.flush();
            } catch (Exception x) {
                x.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
        }
    }

    class OnButtonA extends AsyncTask<Void, Void, Void> {
        int port = 4004;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            int serverPort = 4004;
            String address = "192.168.0.7";

            try {
                InetAddress ipAddress = InetAddress.getByName(address);
                System.out.println("Connecting..." + ipAddress + ":" + serverPort + "--" + address);
                clientSocket = new Socket(ipAddress, serverPort);
                System.out.println("Connected\n");
                System.out.println("Send mess...");
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                out.write("OnButtonA");
                out.flush();
            } catch (Exception x) {
                x.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
        }
    }
    class OffButtonA extends AsyncTask<Void, Void, Void> {
        int port = 4004;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            int serverPort = 4004;
            String address = "192.168.0.7";

            try {
                InetAddress ipAddress = InetAddress.getByName(address);
                System.out.println("Connecting...");
                clientSocket = new Socket(ipAddress, serverPort);
                System.out.println("Connected\n");
                System.out.println("Send mess...");
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                out.write("OffButtonA");
                out.flush();
            } catch (Exception x) {
                x.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
        }
    }

    class OnButtonD extends AsyncTask<Void, Void, Void> {
        int port = 4004;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            int serverPort = 4004;
            String address = "192.168.0.7";

            try {
                InetAddress ipAddress = InetAddress.getByName(address);
                System.out.println("Connecting...");
                clientSocket = new Socket(ipAddress, serverPort);
                System.out.println("Connected\n");
                System.out.println("Send mess...");
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                out.write("OnButtonD");
                out.flush();
            } catch (Exception x) {
                x.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
        }
    }
    class OffButtonD extends AsyncTask<Void, Void, Void> {
        int port = 4004;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            int serverPort = 4004;
            String address = "192.168.0.7";

            try {
                InetAddress ipAddress = InetAddress.getByName(address);
                System.out.println("Connecting...");
                clientSocket = new Socket(ipAddress, serverPort);
                System.out.println("Connected\n");
                System.out.println("Send mess...");
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                out.write("OffButtonD");
                out.flush();
            } catch (Exception x) {
                x.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
        }
    }
}