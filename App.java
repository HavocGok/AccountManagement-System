package com.sql.AccountManagemnet;

import java.util.Scanner;

import com.sql.AccountManagemnet.Service.Account_Service;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "------>>Account Management System<<------" );
        char ch = 'Y';
        Scanner sc = new Scanner(System.in);
        Account_Service accms = new Account_Service();
        int AccountNo;
        String AccName, mobileNo,DOB;
        double balance;
       
        while(ch == 'Y') {
        	System.out.println("1. Add Account Number \n2. View Account Details \n3. Update Account Details \n4. Delete Account \n5. View all Accounts \n6. Credit\n7. Debit\n8.Exit");
        	int option = sc.nextInt();
        	switch(option) {
        	case 1:
        		System.out.println("Insert Account Details :");
    			System.out.println("Enter Account No :-->");
    			AccountNo = sc.nextInt();
    			System.out.println("Enter Account Name :-->");
    			AccName = sc.next();
    			System.out.println("Enter Mobile Number :-->");
    			mobileNo = sc.next();
    			System.out.println("Enter Employee DOB :-->");
    			DOB = sc.next();
    			if(accms.insertAccount(AccountNo, AccName, mobileNo, 0, DOB))
    			{
    				System.out.println("********Account Added Successfully...********");
    			}
    			else
    			{
    				System.out.println("------Something Wrong------");
    			}
    			break;
        	case 2:
        		System.out.println("View Account Details..");
    			System.out.println("Enter Account No :-->");
    			AccountNo = sc.nextInt();
    			accms.viewAccount(AccountNo);
    			break;
        	case 3:
        		System.out.println("Update Account Details :");
    			System.out.println("Enter Account No :-->");
    			AccountNo = sc.nextInt();
    			System.out.println("Enter Account Name :-->");
    			AccName = sc.next();
    			System.out.println("Enter Mobile Number :-->");
    			mobileNo = sc.next();
    			System.out.println("Enter Employee DOB :-->");
    			DOB = sc.next();
    			if(accms.updateAccountDetails(AccountNo, AccName, mobileNo, DOB))
    			{
    				System.out.println("********Account Updated Successfully...********");
    			}
    			else
    			{
    				System.out.println("------Something Wrong------");
    			}
    			break;
        	case 4:
        		System.out.println("Delete Account");
        		System.out.println("Enter Account No :-->");
        		AccountNo = sc.nextInt();
        		if(accms.deleteAccount(AccountNo)) {
        			System.out.println("********Account Deleted Successfully...********");
        		}
        		else {
        			System.out.println("------Something Wrong------");
        		}
        		break;
        	case 5:
        		System.out.println("View All Accounts");
        		accms.viewAllAccount();
        		break;
        	case 6:
        		System.out.println("Credit the amount");
        		System.out.println("Enter Account No :-->");
        		AccountNo = sc.nextInt();
        		System.out.println("Enter the amount to be credited: ");
        		double camt = sc.nextDouble();
        		if(accms.creditAccount(AccountNo, camt))
        		{
        			System.out.println("Successfully Credited...");
        		}
        		else
        		{
        			System.out.println("Transaction Failure");
        		}
        		break;
        	case 7:
        		System.out.println("Credit the amount");
        		System.out.println("Enter Account No :-->");
        		AccountNo = sc.nextInt();
        		System.out.println("Enter the amount to be debited: ");
        		double damt = sc.nextDouble();
        		if(accms.debitAccount(AccountNo, damt))
        		{
        			System.out.println("Successfully Debited...");
        		}
        		else
        		{
        			System.out.println("Transaction Failure");
        		}
        		break;
        	default:
        		System.out.println("Thank You...");
        		break;
        	}
        	System.out.println("You want To Continue(Press Y)");
        	ch = sc.next().charAt(0);
        }
        
    }
}
