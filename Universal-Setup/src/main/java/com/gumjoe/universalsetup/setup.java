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
import java.io.FileInputStream;
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
import com.gumjoe.universalsetup.*;

public class setup
{
    public static void main( String[] args ) throws Exception
    {

        System.out.println( "                                                                                                 " );
        System.out.println( "[INFO]  Hello and welcome to universal-setup" );
        System.out.println( "[INFO]  Running Version: " + version.name + " " + version.versionnumber + "-" + version.versiontype + "-" + version.realesetype );
        System.out.println( "[INFO]  Setup is starting..." );
        System.out.println( "                         " );
        //Starting
        //loading
	    File info = new File("./setup.properties");
        if(!info.exists()){
            System.out.println("[ERROR] Could not find a setup.properties in this directory!");
            System.out.println("[INFO]  Create a setup.properties now? (y/n)");
            Scanner userInputScanner = new Scanner(System.in);
            String create = userInputScanner.nextLine();
            Process process;
            System.out.println(create);
            if(create.equals("y")){
               createprop.create(); 
            }

            }
            Properties setup = new Properties();
            FileInputStream getprop = new FileInputStream("setup.properties");
            setup.load(getprop);
            String temp1[];
            String temp2[];
            String name = setup.getProperty("name");
            String author = setup.getProperty("author");
            String groupid = setup.getProperty("groupid");
            String pack = setup.getProperty("package");
            String language = setup.getProperty("language");
            String type = setup.getProperty("type");
            String method = setup.getProperty("method");
            String location = setup.getProperty("location");
            String descr = setup.getProperty("decription");  
               
            if(type.equals("compile")){
             System.out.println("[INFO]  Compileing Universal-Setup app." + language + " project... >>");
            
             System.out.println("[INFO]  << name: " + name +"." + language );
             System.out.println("[INFO]  << type: " + type);
             System.out.println("[INFO]  << Files to compile at: " + location);
             System.out.println("[INFO]  << description: " + descr );
             System.out.println("[INFO]  << package: " + pack );
             System.out.println("[INFO]  << id: " + groupid );
             System.out.println("[INFO]  << author: " + author );
             System.out.println("[INFO]  --------Universal-Setup-Compile-v0.1--------");
             System.out.println("[INFO]  Compiling " + name + " in " + location + " using " + method );
             File compiler = new File("compiler.sh");
             if(!compiler.exists()){
                get.get("https://raw.githubusercontent.com/Gum-Joe/Universal-Setup/Gum-Joe.properties-includes/compile.sh", "compiler.sh"); 
             }
             run.run("sh compiler.sh " + "'" + method + "'" + "'" + location + "'");

            }      
    
            // Saved for later
           //  System.out.println("[INFO]  >> type: " + type);
            // System.out.println("[INFO]  >> Files Loacted at: " + location);
            // System.out.println("[INFO]  >> Files being downloaded from: " + url);
            // System.out.println("[INFO]  >> Files being saved to: " + target);
            // System.out.println("[INFO]  Setting up Universal-Setup app.null project... >>");
            // System.out.println("[INFO]  << name: " + name +".null" );
            // System.out.println("[INFO]  << description: " + describe );
            // System.out.println("[INFO]  << package: " + packname );
            // System.out.println("[INFO]  << id: " + id );
            // System.out.println("[INFO]  << author: " + author );
            // System.out.println("[INFO]  << setup type: " + Setuptype + " , files located @ " + url ); 
        }
    
}



