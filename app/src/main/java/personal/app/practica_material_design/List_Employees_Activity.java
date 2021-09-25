package personal.app.practica_material_design;

import static personal.app.practica_material_design.AddEmployeeActivity.lstEmployees;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

import personal.app.practica_material_design.adapters.EmployeesAdapter;
import personal.app.practica_material_design.models.EmployeeModel;

public class List_Employees_Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    EmployeesAdapter employeesAdapter;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_employees);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

//        lstEmployees = new ArrayList<>();

/*
        lstEmployees.add(new EmployeeModel(R.drawable.android, "Juan", "Pedro"));
        lstEmployees.add(new EmployeeModel(R.drawable.android, "Juan", "Pedro"));
        lstEmployees.add(new EmployeeModel(R.drawable.android, "Juan", "Pedro"));
        lstEmployees.add(new EmployeeModel(R.drawable.android, "Juan", "Pedro"));
        lstEmployees.add(new EmployeeModel(R.drawable.android, "Juan", "Pedro"));
        lstEmployees.add(new EmployeeModel(R.drawable.android, "Juan", "Pedro"));
        lstEmployees.add(new EmployeeModel(R.drawable.android, "Juan", "Pedro"));
        lstEmployees.add(new EmployeeModel(R.drawable.android, "Juan", "Pedro"));
*/

        setRecyclerView(lstEmployees);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        finish();
        Toast.makeText(List_Employees_Activity.this, "Se destruyo", Toast.LENGTH_SHORT).show();
    }

    private void setRecyclerView(List<EmployeeModel> lstEmployees){
        recyclerView = findViewById(R.id.rvEmployees);

        linearLayoutManager = new LinearLayoutManager(List_Employees_Activity.this, RecyclerView.VERTICAL, false);
//        linearLayoutManager = new GridLayoutManager(List_Employees_Activity.this,2);
        recyclerView.setLayoutManager(linearLayoutManager);

        employeesAdapter = new EmployeesAdapter(lstEmployees);

        recyclerView.setAdapter(employeesAdapter);
    }
}