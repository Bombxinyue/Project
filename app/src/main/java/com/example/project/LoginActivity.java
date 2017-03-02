package com.example.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by 彭欣月 on 2017/3/2.
 */
public class LoginActivity extends Activity {  @Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.login);

    Button button1=(Button) findViewById(R.id.login);
    assert button1 != null;
    button1.setOnClickListener(new View.OnClickListener()
    {

        public void onClick(View v)
        {
            // TODO Auto-generated method stub
            String numbe = ((EditText)findViewById(R.id.editText1)).getText().toString();
            String pwd = ((EditText)findViewById(R.id.editText2)).getText().toString();
            boolean flag=false;
            String nickname="";

            for(int i = 0; i< Data.USER.length; i++)
            {
                if(numbe.equals(Data.USER[i][0]))
                {
                    if(pwd.equals(Data.USER[i][1]))
                    {
                        nickname=Data.USER[i][2];
                        flag=true;
                        break;
                    }
                }
            }
            if(flag)
            {
                Intent intent=new Intent(LoginActivity.this,FActivity.class);
                Bundle bundle= new Bundle();
                bundle.putString("nickname", nickname);
                intent.putExtras(bundle);
                startActivity(intent);
            }
            else
            {
                Toast.makeText(LoginActivity.this, "您输入的账号或密码有错误", Toast.LENGTH_SHORT).show();
            }
        }
    });
    Button exit=(Button) findViewById(R.id.Button01);
    exit.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            finish();
        }
    });
}
}
