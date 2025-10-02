package com.DsaProject.IntPack;

import com.DsaProject.IntPack.curated.Employee;

import java.util.Comparator;

public class EmployeeAgeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee A, Employee B)
    {
        if(A.getAge() < B.getAge())
        {
            return 1;
        }
        else if(A.getAge() > B.getAge())
        {
            return -1;
        }
        return 0;
    }
}
