package com.sivert.controller;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;



public class SecondActivity extends AppCompatActivity {

    OnButtonUp OnBUp;
    OffButtonUp OffUp;

    OnButtonDown OnBDown;
    OffButtonDown OffBDown;

    OnButtonLeft OnBLeft;
    OffButtonLeft OffBLeft;

    OnButtonRight OnBRight;
    OffButtonRight OffBRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.second);
        itemButtonsClick();
    }

    public void Click(View view) {
        Intent intent=new Intent(SecondActivity.this,MainActivity.class);
        startActivity(intent);
    }

    private void itemButtonsClick() {
        ImageButton up = (ImageButton) findViewById(R.id.up);
        ImageButton down = (ImageButton) findViewById(R.id.down);
        ImageButton left = (ImageButton) findViewById(R.id.left);
        ImageButton right = (ImageButton) findViewById(R.id.right);


        up.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    OnBUp = new OnButtonUp();
                    OnBUp.execute();
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    OffUp = new OffButtonUp();
                    OffUp.execute();
                }
                return false;
            }
        });
        down.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    OnBDown = new OnButtonDown();
                    OnBDown.execute();
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    OffBDown = new OffButtonDown();
                    OffBDown.execute();
                }
                return false;
            }
        });
        left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    OnBLeft = new OnButtonLeft();
                    OnBLeft.execute();
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    OffBLeft = new OffButtonLeft();
                    OffBLeft.execute();
                }
                return false;
            }
        });
        right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    OnBRight = new OnButtonRight();
                    OnBRight.execute();
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    OffBRight = new OffButtonRight();
                    OffBRight.execute();
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

    class OnButtonUp extends AsyncTask<Void, Void, Void> {
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
                out.write("OnButtonUp");
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
    class OffButtonUp extends AsyncTask<Void, Void, Void> {
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
                out.write("OffButtonUp");
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

    class OnButtonDown extends AsyncTask<Void, Void, Void> {
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
                out.write("OnButtonDown");
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
    class OffButtonDown extends AsyncTask<Void, Void, Void> {
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
                out.write("OnButtonDown");
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

    class OnButtonLeft extends AsyncTask<Void, Void, Void> {
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
                out.write("OnButtonLeft");
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
    class OffButtonLeft extends AsyncTask<Void, Void, Void> {
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
                out.write("OffButtonLeft");
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

    class OnButtonRight extends AsyncTask<Void, Void, Void> {
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
                out.write("OnButtonRight");
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
    class OffButtonRight extends AsyncTask<Void, Void, Void> {
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
                out.write("OffButtonRight");
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