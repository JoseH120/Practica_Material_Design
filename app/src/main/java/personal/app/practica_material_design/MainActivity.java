package personal.app.practica_material_design;

import static personal.app.practica_material_design.AddEmployeeActivity.lstEmployees;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnAddEmployee , btnLstEmployees, btnMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btnAddEmployee = findViewById(R.id.btnAddEmployee);
        btnLstEmployees = findViewById(R.id.btnListEmployees);
        btnMostrar = findViewById(R.id.btnMostrar);

        btnAddEmployee.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AddEmployeeActivity.class));
        });

        btnLstEmployees.setOnClickListener(v -> {
            if(lstEmployees == null || lstEmployees.isEmpty() ){
                Toast.makeText( MainActivity.this, "Lista Vacia", Toast.LENGTH_SHORT).show();
            }else{
                startActivity(new Intent(MainActivity.this, List_Employees_Activity.class));
            }
        });

        btnMostrar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MostrarDatosActivity.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        Toast.makeText(MainActivity.this, "Se destruyo", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
        Log.i("MainActivity", "invoke onDestroy");
    }
}