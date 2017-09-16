package com.shepard.cyfer.lorc21;

/**
 * Created by Thegan on 2017/09/06.
 */


        import android.app.Activity;
        import android.app.AlertDialog;
        import android.content.Context;
        import android.content.Intent;
        import android.os.AsyncTask;
        import android.util.Log;
        import android.widget.Button;
        import android.widget.TextView;

        import java.io.BufferedReader;
        import java.io.BufferedWriter;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.io.OutputStream;
        import java.io.OutputStreamWriter;
        import java.net.HttpURLConnection;
        import java.net.MalformedURLException;
        import java.net.URL;
        import java.net.URLEncoder;

/**
 * Created by ProgrammingKnowledge on 1/5/2016.
 */
public class BackgroundWorker extends AsyncTask<String,Void,String> {
    Context context;
    AlertDialog alertDialog;
    boolean emaildoesntexists=false;
    boolean userdoesntexists=false;
    boolean validlogin=false;
    BackgroundWorker (Context ctx) {
        context = ctx;
    }
    String gt;
    String fc="";
    String usern="";

    int friendcount;
    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        gt=type;
        String login_url = "http://cyferlan.ddns.net/login.php";
        String reg_url = "http://cyferlan.ddns.net/Register.php";
        String emc_url = "http://cyferlan.ddns.net/Emc.php";
        String userc_url = "http://cyferlan.ddns.net/usernamec.php";
        String getid_url = "http://cyferlan.ddns.net/getidLogin.php";
        String getcount_url = "http://cyferlan.ddns.net/getfriendcount.php";
        if(type.equals("login")) {
            try {
                String user_name = params[1];
                usern=user_name;
                String password = params[2];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(user_name,"UTF-8")+"&"
                        +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!= null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        if(type.equals("register")) {


            //////////////////////////////////////////user
            try {
                String user= params[1];
                URL url = new URL(userc_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("user","UTF-8")+"="+URLEncoder.encode(user,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!= null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                if(result.equals("userdexists")){userdoesntexists=true;}
                Log.e(userdoesntexists+"", "email: user");
                //return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            ///////////////////////////////////////email

            try {
                String email= params[3];
                URL url = new URL(emc_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!= null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                if(result.equals("dexists")){emaildoesntexists=true;}
                Log.e(emaildoesntexists+"", "email: email");
                //return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            if(userdoesntexists  && emaildoesntexists){
            ///////////////////////////Register
            try {
                String user_name = params[1];
                String password = params[2];
                String email= params[3];
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("user_name","UTF-8")+"="+URLEncoder.encode(user_name,"UTF-8")+"&"
                        +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8")+"&"
                        +URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!= null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            }
            else
                {

                return "";
                }
        }





        if(type.equals("fcount")) {
            /////////////////////////////////////////
            String gid="";
            try {
                String user= params[1];
                URL url = new URL(getid_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("user_name","UTF-8")+"="+URLEncoder.encode(user,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!= null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();

                httpURLConnection.disconnect();
                gid=result;
                //return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            /////////////////////////////////////////
            try {
                URL url = new URL(getcount_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("id","UTF-8")+"="+URLEncoder.encode(gid,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!= null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {


    }



    @Override
    protected void onPostExecute(String result) {
       // Log.e(result, "Answer");
        alertDialog = new AlertDialog.Builder(context).create();
        if(gt.equals("register")){
            if(emaildoesntexists && !userdoesntexists)
            {
                AlertDialog alertDialog = new AlertDialog.Builder(context).create();
                alertDialog.setTitle("Error!");
                alertDialog.setMessage("An Account with this Username already exists.");
                alertDialog.show();

            }else
            if(!emaildoesntexists && userdoesntexists)
            {
                alertDialog = new AlertDialog.Builder(context).create();
                alertDialog.setTitle("Error!");
                alertDialog.setMessage("An Account with this Email already exists.");
                alertDialog.show();
            }else if(!emaildoesntexists && !userdoesntexists)
            {
                alertDialog = new AlertDialog.Builder(context).create();
                alertDialog.setTitle("Error!");
                alertDialog.setMessage("An Account with this Email and Username already exists.");
                alertDialog.show();
            }
        if(result.equals("nr"))
        {
            alertDialog.setTitle("Error!");
            alertDialog.setMessage("Unable To Register User!");
            alertDialog.show();
        }else if(result.equals("r")){
            Log.e(result, "Email: Result");
            registerActivity r= new registerActivity();
            r.ret();

        }

    }

        if(gt.equals("login")){

            if(result.equals("l")) {
                Intent intent = new Intent(context, user.class);

              //  intent.putExtra(usern,"username");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                context.startActivity(intent);

                TextView txtView = (TextView) ((Activity)context).findViewById(R.id.txtName);
                txtView.setText(usern);
            }else if(result.equals("nl")){
                alertDialog.setTitle("Error!");
                alertDialog.setMessage("Invalid Username or Password");
                alertDialog.show();
            }

        }
        if(gt.equals("fcount")){
            TextView txtView = (TextView) ((Activity)context).findViewById(R.id.txtFriendCount);


           //friendcount= Integer.parseInt(result+"");
            txtView.setText(result);
            Log.e(friendcount+"", "Cbg");

        }



    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }


    public void Updateuser(){
        TextView txtView = (TextView) ((Activity)context).findViewById(R.id.text);
        txtView.setText("Hello");
    }
}