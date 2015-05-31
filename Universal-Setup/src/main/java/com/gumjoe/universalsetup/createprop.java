package com.gumjoe.universalsetup;

import com.google.common.base.Charsets;
import com.google.common.base.Predicate;
import com.google.common.base.Throwables;
import com.google.common.collect.Iterables;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import com.google.common.io.ByteStreams;
import com.google.common.io.CharStreams;
import com.google.common.io.Files;
import com.google.common.io.Resources;
import com.google.gson.Gson;
import difflib.DiffUtils;
import difflib.Patch;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.util.*;

import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.OptionSpec;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.output.TeeOutputStream;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.ResetCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.revwalk.RevCommit;
import com.gumjoe.universalutils.*;

public class createprop
{
    public static void create() throws Exception
    {
        PrintStream console = System.out;
		File file = new File("setup.properties");
		FileOutputStream fos = new FileOutputStream(file);
		PrintStream ps = new PrintStream(fos);
        


        System.out.println("First, type the name of the package...  ");
        Scanner userInputScanner = new Scanner(System.in);
        String name = userInputScanner.nextLine();
        System.setOut(ps);
        System.out.println("name=" + name);
        System.setOut(console);

        
        //author
        System.out.println("Now type in the author of this package...  ");
        Scanner userInputScannerone = new Scanner(System.in);
        String author = userInputScannerone.nextLine();
        System.setOut(ps);
        System.out.println("author=" + author);
        System.setOut(console);
        //describe
        System.out.println("Type a brief decription of the project...  ");
        Scanner userInputScannerZ = new Scanner(System.in);
        String des = userInputScannerZ.nextLine();
        System.setOut(ps);
        System.out.println("decription=" + des);
        System.setOut(console);
         
        //groupid
        System.out.println("What's your group ID (e.g: com.gumjoe)  ");
        Scanner userInputScannertwo = new Scanner(System.in);
        String gid = userInputScannertwo.nextLine();
        System.setOut(ps);
        System.out.println("groupid=" + gid);
        System.setOut(console);
        
        //package
        System.out.println("What's the package called (e.g: com.gumjoe.packagename)");
        Scanner userInputScannerthree = new Scanner(System.in);
        String pack = userInputScannerthree.nextLine();
        System.setOut(ps);
        System.out.println("package=" + pack);
        System.setOut(console);
         
        //language
        System.out.println("What is the language of your package? (java, ruby .etc) - we only support java at the moment");
        Scanner userInputScannerfour = new Scanner(System.in);
        String lang = userInputScannerfour.nextLine();
        System.setOut(ps);
        System.out.println("language=" + lang);
        System.setOut(console);
        
        //type
        System.out.println("What is the setup type you want? (compile, install .etc)");
        Scanner userInputScannerfive = new Scanner(System.in);
        String type = userInputScannerfive.nextLine();
        System.setOut(ps);
        System.out.println("type=" + type);
        System.setOut(console);
        
        if(type.equals("compile")){
            //compile command
            System.out.println("What command should we use to compile (this is the command you use to compile your package, e.g: 'mvn clean install' ?  ");
            Scanner userInputScannersix = new Scanner(System.in);
            String commethod = userInputScannersix.nextLine();
            System.setOut(ps);
            System.out.println("method=" + commethod);
            System.setOut(console);
            
            //package location
            System.out.println("Where will the package specifier (pom.xml for maven .etc) for your package be stored (if they are loacated where setup.properties is located just type './'m without the quotes)?  ");
            Scanner userInputScannerseven = new Scanner(System.in);
            String loc = userInputScannerseven.nextLine();
            System.setOut(ps);
            System.out.println("location=" + loc);
            System.setOut(console);

        }
        if(type.equals("install")){
             //files-web-location
            System.out.println("Are your files located on the internet (type 'internet' - no quotes),  a git repo (type 'git' - no quotes) or locally (type 'local' - no quotes) ?  ");
            Scanner userInputScannereight = new Scanner(System.in);
            String fileslocinter = userInputScannereight.nextLine();
            System.setOut(ps);
            System.out.println("filesloacation=" + fileslocinter);
            System.setOut(console);

            
            if(fileslocinter.equals("git")){
                //git-repo
                System.out.println("What's the url for your git repo?  ");
                Scanner userInputScannernine = new Scanner(System.in);
                String gitloc = userInputScannernine.nextLine();
                System.setOut(ps);
                System.out.println("gitrepo=" + gitloc);
                System.setOut(console);

                
                //tmp-loc
                System.out.println("Where should we save the files ready for installation?  ");
                Scanner userInputScannerten = new Scanner(System.in);
                String gitstore = userInputScannerten.nextLine();
                System.setOut(ps);
                System.out.println("tmpdir=" + gitstore);
                System.setOut(console);
 
            }
            if(fileslocinter.equals("internet")){
                //url
                System.out.println("What's the url for your files?  ");
                Scanner userInputScannereleven = new Scanner(System.in);
                String internetloc = userInputScannereleven.nextLine();
                System.setOut(ps);
                System.out.println("url=" + internetloc);
                System.setOut(console);

                
                //storage-type
                System.out.println("What sort of archieve are they stored in ('.tar.gz' .etc)?  ");
                Scanner userInputScannerA = new Scanner(System.in);
                String artype = userInputScannerA.nextLine();
                System.setOut(ps);
                System.out.println("artype=" + internetloc);
                System.setOut(console);

                
                //tmp-loc
                System.out.println("Where should we save the files ready for installation?  ");
                Scanner userInputScannerB = new Scanner(System.in);
                String store = userInputScannerB.nextLine();
                System.setOut(ps);
                System.out.println("tmpdir=" + store);
                System.setOut(console);
            } 
        }
        System.out.println("Thanks, we've succesfully made your setup.properties, now just re-run setup.jar to continue");
        System.exit(0);
    }
 }