package com.example.popularmoviesstage1;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity  implements FilmAdapter.ListItemClickListener  {
    String urlJson="http://api.themoviedb.org/3/movie/popular?api_key=37789dc48bb9195cdca528bdbc31ce85";
   // String urlJson;

    private FilmAdapter mAdapter;
    private RecyclerView recyclerView;
    TextView textView;
    MoviesModel moviesModel;
int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FechData fechData=new FechData();
       // textView=findViewById(R.id.idd);
        fechData.execute();
            recyclerView = (RecyclerView) findViewById(R.id.RV_Movies);


    }

    private MainActivity getAction() {
        return MainActivity.this;
    }


    /* ----------------------  Menu List Code--------------------------- */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId())
        {
            case R.id.SortByPopularity: {
                urlJson = "http://api.themoviedb.org/3/movie/popular?api_key=37789dc48bb9195cdca528bdbc31ce85";
                Toast.makeText(this, "Sorted By Poroperty", Toast.LENGTH_LONG).show();

                FechData f1=new FechData();
                f1.execute();
                break;
            }
            case R.id.SortByRate: {
               urlJson = "http://api.themoviedb.org/3/movie/top_rated?api_key=37789dc48bb9195cdca528bdbc31ce85";
                Toast.makeText(this, "Sorted By Rate", Toast.LENGTH_LONG).show();
                FechData f2=new FechData();
                f2.execute();
                break;
            }

        }
      return  super.onOptionsItemSelected(item);

    }

    /* ----------------------  ------------------------------- */
/*-----------------------Recycle view onclick--------------------------*/


//    @Override
//    public void onListItemClick(int clickedItemIndex) {
//        Toast.makeText(this, "click on item: ", Toast.LENGTH_LONG).show();
//    }

    @Override
      public void onClick(MoviesModel model, int position) {


                Intent intent = new Intent(this, DetailsActivity.class);
                intent.putExtra("poster_path" , model.getPoster_path().get(position));
                intent.putExtra("original_title" , model.getOriginal_title().get(position));
                intent.putExtra("vote_count" , model.getVote_count().get(position));
                intent.putExtra("release_date" , model.getRelease_date().get(position));
                intent.putExtra("overview" , model.getOverview().get(position));
                startActivity(intent);

     }

    /*-------------------------------------------------*/
    public class FechData extends AsyncTask<URL, Void, String>  {
        String data = "";
//        String urldata;
//
//        FechData(String urldata){
//            this.urldata=urldata;
//        }
//        FechData(){
//
//        }

      @Override
        protected String doInBackground(URL... urls) {

            try {


               // URL url = new URL("http://api.themoviedb.org/3/movie/popular?api_key=37789dc48bb9195cdca528bdbc31ce85");
                URL url = new URL(urlJson);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                while (line != null) {
                    line = bufferedReader.readLine();
                    data = data + line;
                }



                // Log.d((String) Tag,data);

            } catch (MalformedURLException e) {

                return e.getMessage();
            } catch (IOException e) {
                return e.getMessage();
            }
//        JsonUtils jsonUtils=new  JsonUtils();
//        moviesModel=  jsonUtils.parseMoviesModelJson(data);
            return data;



        }





        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (data != null && !data.equals("")) {
                try {

              JsonUtils jsonUtils=new  JsonUtils();
             moviesModel=  jsonUtils.parseMoviesModelJson(s);
                    GridLayoutManager layoutManager=new GridLayoutManager(MainActivity.this,2);

                 mAdapter = new FilmAdapter( getAction(), moviesModel);
                   // mAdapter = new FilmAdapter(moviesModelel);
                    recyclerView.setAdapter(mAdapter);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(layoutManager);
               // textView.setText(moviesModel.getPoster_path().get(0));
                }catch (Exception e)
                {
                  //  textView.setText(e.getMessage());

                }



            }
        }


    }


}
