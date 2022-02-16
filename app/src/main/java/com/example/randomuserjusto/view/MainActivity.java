package com.example.randomuserjusto.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.randomuserjusto.R;
import com.example.randomuserjusto.apiclient.entities.User;
import com.example.randomuserjusto.presenter.MainPresenter;
import retrofit.RetrofitError;

public class MainActivity extends AppCompatActivity implements MainViewInterface {

    private MainPresenter mainPresenter;
    private String dialogTitle = "Lo sentimos";
    private String dialogMessage = "Ocurrio un error al obtener los datos del usuario.";

    ImageView imageViewAvatar;
    TextView textViewName;
    TextView textViewEmail;
    TextView textViewNumber;
    TextView textViewGender;
    TextView textViewAge;

    TextView textViewAddress;
    TextView textViewStateCity;
    TextView textViewCountry;
    TextView textViewTimeZone;
    TextView textViewUserName;
    TextView textViewDateRegistered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter = new MainPresenter(this);
        mainPresenter.getUserData();
        initViews();
    }

    @Override
    public void displayUserData(User user) {

        mainPresenter.loadAvatar(user.getPicture().getMedium());

        String name = user.getName().getTitle() + " " + user.getName().getFirst() + " " + user.getName().getLast();
        String years = user.getDob().getAge() + " years";
        String street = user.getLocation().getStreet().getName() + " " + user.getLocation().getStreet().getNumber();
        String stateCity = user.getLocation().getState() + ", " + user.getLocation().getCity();

        textViewName.setText(name);
        textViewEmail.setText(user.getEmail());
        textViewNumber.setText(user.getPhone());
        textViewGender.setText(user.getGender());
        textViewAge.setText(years);
        textViewAddress.setText(street);
        textViewStateCity.setText(stateCity);
        textViewCountry.setText(user.getLocation().getCountry());
        textViewTimeZone.setText(user.getLocation().getTimezone().getDescription());
        textViewUserName.setText(user.getLogin().getUsername());
        textViewDateRegistered.setText(user.getRegistered().getDate());
    }

    @Override
    public void displayUserImage(Bitmap image) {

        this.runOnUiThread(() -> {
            imageViewAvatar.setImageBitmap(image);
        });

    }

    @Override
    public void errorFetchingUserData(RetrofitError error) {
        dialogError(this, dialogTitle, dialogMessage).show();
    }

    public void initViews(){
        imageViewAvatar = findViewById(R.id.imageViewAvatar);
        textViewName = findViewById(R.id.textViewName);
        textViewEmail = findViewById(R.id.textViewEmail);
        textViewNumber = findViewById(R.id.textViewNumber);
        textViewGender = findViewById(R.id.textViewGender);
        textViewAge = findViewById(R.id.textViewAge);
        textViewAddress = findViewById(R.id.textViewAddress);
        textViewStateCity = findViewById(R.id.textViewStateCity);
        textViewCountry = findViewById(R.id.textViewCountry);
        textViewTimeZone = findViewById(R.id.textViewTimeZone);
        textViewUserName = findViewById(R.id.textViewUserName);
        textViewDateRegistered = findViewById(R.id.textViewDateRegistered);
    }

    public AlertDialog dialogError(Context context, String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.ThemeOverlay_AppCompat_Dialog_Alert);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton("Ok", (dialog, which) -> {
                    dialogError(context,title, message).dismiss();
                });
        return builder.create();
    }
}