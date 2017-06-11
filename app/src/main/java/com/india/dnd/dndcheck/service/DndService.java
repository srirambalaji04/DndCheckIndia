package com.india.dnd.dndcheck.service;

import android.app.Application;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.octo.android.robospice.SpiceService;
import com.octo.android.robospice.persistence.CacheManager;
import com.octo.android.robospice.persistence.string.InFileStringObjectPersister;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

/**
 * Created by sriram on 30/10/16.
 */

public class DndService extends SpiceService{

    private static String getSerializableFromCache(File paramFile)
    {
        if (paramFile.exists()) {}
        try
        {
            ObjectInputStream localObjectInputStream = new ObjectInputStream(new FileInputStream(paramFile));
            String str = (String)localObjectInputStream.readObject();
            localObjectInputStream.close();
            return str;
        }
        catch (StreamCorruptedException localStreamCorruptedException)
        {
            localStreamCorruptedException.printStackTrace();
            return null;
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
            for (;;)
            {
                localFileNotFoundException.printStackTrace();
            }
        }
        catch (IOException localIOException)
        {
            for (;;)
            {
                localIOException.printStackTrace();
            }
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
            for (;;)
            {
                localClassNotFoundException.printStackTrace();
            }
        }
    }


    private static void saveSerializableToCache(Object paramObject, File paramFile)
    {
        try
        {
            ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
            localObjectOutputStream.writeObject(paramObject);
            localObjectOutputStream.close();
            byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
            FileOutputStream localFileOutputStream = new FileOutputStream(paramFile);
            localFileOutputStream.write(arrayOfByte);
            localFileOutputStream.close();
            return;
        }
        catch (IOException localIOException)
        {
            localIOException.printStackTrace();
        }
    }

    @Override
    public CacheManager createCacheManager(Application paramApplication) {
        CacheManager localCacheManager = new CacheManager();
        localCacheManager.addPersister(new InFileStringObjectPersister(paramApplication));
        return localCacheManager;
    }


}
