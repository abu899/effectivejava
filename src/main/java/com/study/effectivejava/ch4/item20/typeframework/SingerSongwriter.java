package com.study.effectivejava.ch4.item20.typeframework;

public interface SingerSongwriter extends Singer, Songwriter{

    AudioClip strum();
    void actSensitive();
}
