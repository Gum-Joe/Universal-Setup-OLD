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

public class setup
{
    public static void setup( String Setuptype, String FileLoc, String url, File target, File installLoc  ) throws Exception
    {
        System.out.println( version.name + " " + version.versionnumber + "-" + version.versiontype + "-" + version.realesetype );
        System.out.println( "[INFO] Setup is starting..." );
        //Starting
        //loading
	    File info = new File("./info.json");
        if(!info.exists()){
            System.out.println("[ERROR] Could not find info.json, using specified options:");
            System.out.println("[INFO]  >> type: " + Setuptype);
            System.out.println("[INFO]  >> Files Loacted on: " + FileLoc);
            System.out.println("[INFO]  >> Files being downloaded from: " + url);
            System.out.println("[INFO]  >> Files being saved to: " + target);
            System.out.println("[INFO]  Setting up Universal-Setup app.null project... >>");
            System.out.println("[INFO]  << setup type: " + Setuptype + " , files located @ " + url );
            if(Setuptype=="clone"){
               // Construction: "setup, git, url, target"
               if(FileLoc=="git"){
                   clone.clone(url, target);
               }
               if(FileLoc=="internet"){
                   // Replace when get avalible in universal utils
                   // get.get(url, target);
               }
            }else{
                if(Setuptype=="compile"){
                    System.out.println("[ERROR] info.json does not exit!");
                    System.exit(1);
                }
            } 
        } else {
            run.run("Setup.sh");
            System.exit(0);
        }
        if(Setuptype=="install"){
            //replace when avalible
            // get.get(url, target);
            // copy.copy(target, installLoc);
        }
    
}
             
}



