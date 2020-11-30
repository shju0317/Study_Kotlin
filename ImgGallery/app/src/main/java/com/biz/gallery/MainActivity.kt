package com.biz.gallery

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import com.biz.gallery.ui.login.LoginActivity

class MainActivity : AppCompatActivity() {

    private lateinit var imgView : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        imgView = findViewById(R.id.imgView)

        val fab : FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->

            // 이미지 갤러리 폴더를 열어서 보여달라
            // 시스템에 내장된 Intent 호출 중에서 가져오기(PICK) 인텐트를 사용하겠다
            val imgIntent = Intent(Intent.ACTION_PICK)

            // 내장된 컨텐츠를 가져오는 기능
            imgIntent.type = MediaStore.Images.Media.CONTENT_TYPE

            // 컨텐츠의 저장된 위치 등의 정보를 달라
            imgIntent.data = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            
            // Activity를 호출한 후 호출된 activity가 종료할 때
            // 어떤 값을 return하면 그값을 수신하겠다라는 전제하에 사용하는 method
            // requestCode : 호출하는 activity에 대해 임의로 설정한 key값
            startActivityForResult(imgIntent, REQ_CODE_SELECT_IMAGE)
        }
    }

    /*
    호출받은 Activity에서 setResult() method가 실행되고 
    결과값을 return할 때 호출되는 event handler
    fab의 click event에서 사진 갤러리르 open하고 사진을 선택(클릭)했을 때
    그 결과를 수신할 method
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQ_CODE_SELECT_IMAGE){
            if(resultCode == RESULT_OK){
                // 사진갤러리 Activity가 되돌려준 사진정보를 inputStream으로 변환하여
                // expecting Property로 변환시킨다
                // expecting Property는 변수이름을 백팃으로 감싼다
                val `in` = contentResolver.openInputStream(data!!.data!!)
                // BitMap : 픽셀구조로 된 이미지 정보
                val imgBitMap = BitmapFactory.decodeStream(`in`)
                imgView.setImageBitmap(imgBitMap)
                `in`!!.close()

            }
        }
    }
    
    // static final변수를 선언
    companion object{
        private const val REQ_CODE_SELECT_IMAGE = 1
    }

    // onCreate()에서 setSupportActionBar메서드가 실행될 때 호출
    // 햄버거 메뉴를 생성하는 LifeCycle method
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    // 햄버거 메뉴를 확장하고, 항목을 클릭(선택)했을 때 발생하는 이벤트
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        /*
        app에 여러개의 화면을 구성하여 화면 전환하기1
        최초로 생성된 프로젝트에는 MainActivity가 있다.
        MainActivity는 안드로이드 OS가 호출하여 화면을 구성하는 용도로 사용하는 클래스

        만약 여러개의 화면(기능)을 가진 app을 만드려면
        Activity를 추가한다.
        그러면 androidManifest.xml에 Activity가 등록된다.

        main()에서 생성된 Activity를 열기
        1. Intent클래스를 사용하여 intent객체를 생성
            Intent(누가, 누구를)
            가. java에서 누가 : MainActivity.this, 누구를 LoginActivity.class
            나. Kotlin에서 누가 : this, 누구를 : LoginActivity::class.java
        2. startActivity(intent)형식으로 open


         */
        return when (item.itemId) {
            R.id.action_settings -> true
            R.id.action_login -> { // 햄버거-로그인메뉴 선택시
                /*
                명시적 Intent 호출
                activity를 생성한 후 main에서 activity를 호출하여 화면을 불러오기
                사용자 생성 Intent 호출
                 */
                val loginIntent: Intent = Intent(this, LoginActivity::class.java)

                loginIntent.putExtra("username","shju0317@naver.com")
                startActivity(loginIntent)
                true
            }
            R.id.action_phone -> {
                val number : String = "tel:010-1111-1111"

                /*암시적 Intent 호출
                만약 device에 전화걸기 어플이 다수 설치되어 있을 때
                어플에서 전화걸기Intent를 호출하면 device OS에 설정된 기본어플을
                실행하여 전화걸기 화면을 보여주는 것
                전화걸기 어플이 무엇이 있던지 생관없이 내가 만든 어플에서
                전화걸기를 수행할 수 있다
                특정한 어플에 종속되는 것을 막아서 어플이 오류가 나는 것을 최소화하기 위한 것
                 */
                // number변수에 담긴 문자열을 기준으로 전화화면 띄우기
                val phoneDialIntent: Intent = Intent(Intent.ACTION_DIAL, Uri.parse(number))

                val phoneCallButtonIntent: Intent = Intent(Intent.ACTION_CALL_BUTTON, Uri.parse(number))

                // number변수에 담긴 문자열을 기준으로 바로 call
                val phoneCallIntent: Intent = Intent(Intent.ACTION_CALL, Uri.parse(number))
                startActivity(phoneDialIntent)
                true
            }

            R.id.action_internet -> {

                // 인터넷의 특정한 주소페이지를 열고자 할 때
               val naver = "https://www.naver.com"
                // Uri부분을 생략하면 기본 browser가 열림
                val internetIntent = Intent(Intent.ACTION_VIEW, Uri.parse(naver))

                //
                startActivity(internetIntent)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}