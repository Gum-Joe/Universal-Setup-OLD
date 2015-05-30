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
        File setupprop = new File("setup.properties");
        setupprop.createNewFile();
        FileWriter fileWriter = new FileWriter(setupprop, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        System.out.println("First, type the name of the package...  ");
        Scanner userInputScanner = new Scanner(System.in);
        String name = userInputScanner.nextLine();
        bufferedWriter.write("name=" + name);

        
        //author
        System.out.println("Now type in the author of this package...  ");
        Scanner userInputScannerone = new Scanner(System.in);
        String author = userInputScannerone.nextLine();
        bufferedWriter.write("author=" + author);
         
        //groupid
        System.out.println("What's your group ID (e.g: com.gumjoe)  ");
        Scanner userInputScannertwo = new Scanner(System.in);
        String gid = userInputScannertwo.nextLine();
        bufferedWriter.write("groupid=" + gid);
        
        //package
        System.out.println("What's the package called (e.g: com.gumjoe.packagename)");
        Scanner userInputScannerthree = new Scanner(System.in);
        String pack = userInputScannerthree.nextLine();
        bufferedWriter.write("package=" + pack);

         
        //language
        System.out.println("What is the language of your package? (java, ruby .etc) - we only support java at the moment");
        Scanner userInputScannerfour = new Scanner(System.in);
        String lang = userInputScannerfour.nextLine();
        bufferedWriter.write("language=" + lang);

        
        //type
        System.out.println("What is the setup type you want? (compile, install .etc)");
        Scanner userInputScannerfive = new Scanner(System.in);
        String type = userInputScannerfive.nextLine();
        bufferedWriter.write("type=" + type);

        
        if(type=="compile"){
            //compile command
            System.out.println("What command should we use to compile (this is the command you use to compile your package, e.g: 'mvn clean install' ?  ");
            Scanner userInputScannersix = new Scanner(System.in);
            String commethod = userInputScannersix.nextLine();
            bufferedWriter.write("method=" + commethod);

            
            //package location
            System.out.println("Where will the package specifier (pom.xml for maven .etc) for your package be stored (if they are loacated where setup.properties is located just type './'m without the quotes)?  ");
            Scanner userInputScannerseven = new Scanner(System.in);
            String loc = userInputScannerseven.nextLine();
            bufferedWriter.write("location=" + loc);

        }
        if(type=="install"){
             //files-web-location
            System.out.println("Are your files located on the internet (type 'internet' - no quotes),  a git repo (type 'git' - no quotes) or locally (type 'local' - no quotes) ?  ");
            Scanner userInputScannereight = new Scanner(System.in);
            String fileslocinter = userInputScannereight.nextLine();
            bufferedWriter.write("filesloacation=" + fileslocinter);

            
            if(fileslocinter=="git"){
                //git-repo
                System.out.println("What's the url for your git repo?  ");
                Scanner userInputScannernine = new Scanner(System.in);
                String gitloc = userInputScannernine.nextLine();
                bufferedWriter.write("gitrepo=" + gitloc);

                
                //tmp-loc
                System.out.println("Where should we save the files ready for installation?  ");
                Scanner userInputScannerten = new Scanner(System.in);
                String gitstore = userInputScannerten.nextLine();
                bufferedWriter.write("tmpdir=" + gitstore);
 
            }
            if(fileslocinter=="internet"){
                //url
                System.out.println("What's the url for your files?  ");
                Scanner userInputScannereleven = new Scanner(System.in);
                String internetloc = userInputScannereleven.nextLine();
                bufferedWriter.write("url=" + internetloc);

                
                //storage-type
                System.out.println("What sort of archieve are they stored in ('.tar.gz' .etc)?  ");
                Scanner userInputScannerA = new Scanner(System.in);
                String artype = userInputScannerA.nextLine();;
                bufferedWriter.write("artype=" + internetloc);

                
                //tmp-loc
                System.out.println("Where should we save the files ready for installation?  ");
                Scanner userInputScannerB = new Scanner(System.in);
                String store = userInputScannerB.nextLine();
                bufferedWriter.write("tmpdir=" + store);
                bufferedWriter.close();
            } 
        }
        System.out.println("Thanks, we've succesfully made your setup.properties, now just re-run setup.jar to continue");
        System.exit(0);
    }
 }