package com.fquiz.worldcupquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class MainActivity : AppCompatActivity() {
    private final var TAG = "MainActivity"
    private var mInterstitialAd: InterstitialAd? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bt_start: Button = findViewById(R.id.btStart)
        val et_name: EditText = findViewById(R.id.et_name)
        val adview: AdView = findViewById(R.id.adview)

        MobileAds.initialize(this@MainActivity)
        var adRequest = AdRequest.Builder().build()
        adview.loadAd(adRequest)

        InterstitialAd.load(this, "ca-app-pub-9198296341022082/6867963623", adRequest, object :
            InterstitialAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
                mInterstitialAd = null
            }

            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                mInterstitialAd = interstitialAd
            }
        })
        mInterstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
            override fun onAdClicked() {
                // Called when a click is recorded for an ad.
                Log.d(TAG, "Ad was clicked.")
            }

            override fun onAdDismissedFullScreenContent() {
                // Called when ad is dismissed.
                Log.d(TAG, "Ad dismissed fullscreen content.")
                mInterstitialAd = null
            }

            override fun onAdImpression() {
                // Called when an impression is recorded for an ad.
                Log.d(TAG, "Ad recorded an impression.")
            }

            override fun onAdShowedFullScreenContent() {
                // Called when ad is shown.
                Log.d(TAG, "Ad showed fullscreen content.")
            }
        }

        bt_start.setOnClickListener {
            if (mInterstitialAd != null) {
                mInterstitialAd?.show(this)

            } else {
                Log.d("TAG", "The ad was not loaded yet")
            }
            if (et_name.text.isEmpty()) {
                Toast.makeText(this, "please enter your name", Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(this, questionActivity::class.java)
                intent.putExtra(Constants.USER_NAME, et_name.text.toString())
                startActivity(intent)
            }
        }

    }

}