package com.kewo.huda;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

public class fb extends AppCompatActivity {
Button share;
ShareDialog shareDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fb);
       share = findViewById(R.id.share);

       shareDialog = new ShareDialog(this);
       share.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               ShareLinkContent linkContent = new ShareLinkContent.Builder().setQuote("Hey").setContentUrl(Uri.parse("https://youtube.com")).build();
               if(ShareDialog.canShow(ShareLinkContent.class)){
                   shareDialog.show(linkContent);
               }
           }
       });


    }

//    private void printkeyhash() {
//        try{
//            PackageInfo info = getPackageManager().getPackageInfo("com.kewo.huda", PackageManager.GET_SIGNATURES);
//            for(Signature signature : info.signatures){
//                MessageDigest md = MessageDigest.getInstance("SHA");
//                md.update(signature.toByteArray());
//                Log.d("KeyHash", Base64.encodeToString(md.digest(),Base64.DEFAULT));
//            }
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//    }
}
