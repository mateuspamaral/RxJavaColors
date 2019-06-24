package br.com.digitalhouse.rxjavacolors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Arrays;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciandoComRXJava();
    }

    private void iniciandoComRXJava() {
        //Com array list
        Observable.fromIterable(Arrays.asList("azul", "rosa", "vermelho", "branco", "preto", "verde", "amarelo"))
                .subscribe(System.out::println);

        //Com create e onNext explícito
        Observable<String> stringObservable = Observable.create(emitter -> {
            emitter.onNext("azul");
            emitter.onNext("rosa");
            emitter.onNext("vermelho");
            emitter.onNext("branco");
            emitter.onNext("preto");
            emitter.onNext("verde");
            emitter.onNext("amarelo");
        });

        stringObservable.subscribe(string -> {
            System.out.println(string);
        }, throwable -> {
            System.out.println(throwable.getMessage());
        }, () -> {
            System.out.println("Completou, não emite mais eventos");
        });
    }
}