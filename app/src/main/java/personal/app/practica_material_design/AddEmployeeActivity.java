package personal.app.practica_material_design;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;
import java.util.ArrayList;

import personal.app.practica_material_design.models.EmployeeModel;
import personal.app.practica_material_design.utils.Utils;

public class AddEmployeeActivity extends AppCompatActivity {
    private Button btnAdd;
    private EditText edtName, edtLastName;
    public static List<EmployeeModel> lstEmployees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        btnAdd = findViewById(R.id.btnAdd);
        edtName =  findViewById(R.id.edtName);
        edtLastName = findViewById(R.id.edtLastName);

        btnAdd.setOnClickListener(v -> {
            if(Utils.verifyEditText(edtName) && Utils.verifyEditText(edtLastName))
            {
                lstEmployees.add(new EmployeeModel(R.drawable.androide, edtName.getText().toString(), edtLastName.getText().toString()));
                Toast.makeText(AddEmployeeActivity.this, "Agregado", Toast.LENGTH_SHORT).show();
            }
        });

        if(lstEmployees == null){
            lstEmployees = new ArrayList<>();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        Toast.makeText(AddEmployeeActivity.this, "Se destruyo", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
            break;
        }
        return true;
    }
}