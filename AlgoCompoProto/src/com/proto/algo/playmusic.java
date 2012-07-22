package com.proto.algo;

import com.jsyn.JSyn;
import com.jsyn.Synthesizer;
import com.proto.algo.playmusic.MyVoiceFactory;
import com.jsyn.instruments.ClassicSynthVoice;
import com.jsyn.unitgen.LineOut;
import com.jsyn.unitgen.SawtoothOscillator;
import com.jsyn.unitgen.SineOscillator;
import com.jsyn.unitgen.SquareOscillator;
import com.jsyn.unitgen.TriangleOscillator;
import com.jsyn.unitgen.UnitOscillator;
import com.jsyn.unitgen.UnitVoice;
import com.jsyn.util.VoiceAllocator;
import com.jsyn.util.VoiceFactory;
import com.softsynth.shared.time.TimeStamp;

public class playmusic {
	private Synthesizer synth;
	private static final int MAX_VOICES = 8;
	private VoiceAllocator allocator;
	private VoiceFactory factory;
	private LineOut lineOut;
	// emotional parameters arousal and valence set to neutral
	public static double aro = 5.0;
	public static double val = 5.0;
	// how far in advance to create music
	private double advance = 0.2;
	// private double secondsPerBeat = 0.6;
	private double secondsPerBeat = .4;
	// on time over note duration
	private double dutyCycle = 0.8;
	private double measure = secondsPerBeat * 4.0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// initialize synthesizer
		new playmusic().play();
		// 1.take input seed
		// initial seed will be hard-coded

		// 2.take word input and translate the word score into valence and
		// arousal scores
		// more words will need a database lookup

		// 3.manipulate music

		// evaluate score function
		pickalgorithm(val, aro);

		// 4.output music and change timetable

		// repeat (make 2 - 4 loop conditionally)
	}

	public static void pickalgorithm(double val, double aro) {
		// nested if statements
		// evaluate valence
		if (val <= 5.0) {
			// negative mood
			if (aro <= 5.0)
			// low arousal
			{// play sad

			}

			else
			// high arousal
			{// play war

			}
		} else {
			// positive emotion
			if (aro <= 5.0) {
				// low arousal
				// play peace
			} else {
				// high arousal
				// play happy
			}
		}
	}

	private void play() {
		synth = JSyn.createSynthesizer();

		// Add an output.
		synth.add(lineOut = new LineOut());

		allocator = new VoiceAllocator(MAX_VOICES);
		factory = new MyVoiceFactory();
		allocator.setVoiceFactory(factory);

		// Start synthesizer using default stereo output at 44100 Hz.
		synth.start();

		double timeNow = synth.getCurrentTime() - 1 ;
		// Advance to a near future time so we have a clean start.
		double time = timeNow + 2;

		// We only need to start the LineOut. It will pull data from the
		// voices.
		synth.startUnit(lineOut, time);

		// FOR TESTING: DELETE PLZ
		try {
			// int tonic = 60 - 12;
			// int tonic = 60 - 24;
			int tonic = 60;
			
			// PoC for loops Sad, Peace, War, Happy
			for (int i = 0; i < 4; i++) {
				double r = tonic;
				playsadMeasure(time, (int) r);
				time += measure;
				r = tonic + 5;
				playsadMeasure(time, (int) r);
				time += measure;
				r = tonic + 7;
				playsadMeasure(time, (int) r);
				time += measure;
				r = tonic;
				playsadMeasure(time, (int) r);
				time += measure;
			}
			for (int i = 0; i < 4; i++) {
				double r = tonic;
				playpeaceMeasure(time, (int) r);
				time += measure;
				r = tonic + 5;
				playpeaceMeasure(time, (int) r);
				time += measure;
				r = tonic + 7;
				playpeaceMeasure(time, (int) r);
				time += measure;
				r = tonic;
				playpeaceMeasure(time, (int) r);
				time += measure;
			}

			for (int i = 0; i < 4; i++) {
				double r = tonic;
				playwarMeasure(time, (int) r);
				time += measure;
				r = tonic + 5;
				playwarMeasure(time, (int) r);
				time += measure;
				r = tonic + 7;
				playwarMeasure(time, (int) r);
				time += measure;
				r = tonic;
				playwarMeasure(time, (int) r);
				time += measure;
			}

			
			
			
			for (int i = 0; i < 4; i++) {
				double r = tonic;
				playhappyMeasure(time, (int) r);
				time += measure;
				r = tonic + 5;
				playhappyMeasure(time, (int) r);
				time += measure;
				r = tonic + 7;
				playhappyMeasure(time, (int) r);
				time += measure;
				r = tonic;
				playhappyMeasure(time, (int) r);
				time += measure;
			}

			for (int i = 0; i < 4; i++) {
				/*
				 * noteOn( time, tonic +i); catchUp(time); noteOff(
				 * time+dutyCycle*secondsPerBeat, tonic+i); time +=
				 * secondsPerBeat; catchUp(time);
				 */
				/*
				 * double r = tonic + (Math.random() * 24.0);
				 * playhappyMeasure(time, (int) r); time += measure;
				 * catchUp(time); r = tonic + (Math.random() * 24.0);
				 * playpeaceMeasure(time, (int) r); time += measure;
				 * catchUp(time); r = tonic + (Math.random() * 24.0);
				 * playsadMeasure(time, (int) r); time += measure;
				 * catchUp(time); r = tonic + (Math.random() * 24.0);
				 * playwarMeasure(time, (int) r); time += measure;
				 */

				// 50's pop progression (Clayton)
				/*
				 * double r = tonic; playwarMeasure(time, (int) r); time +=
				 * measure; catchUp(time); r = tonic - 3; playwarMeasure(time,
				 * (int) r); time += measure; catchUp(time); r = tonic + 2 ;
				 * playwarMeasure(time, (int) r); time += measure;
				 * catchUp(time); r = tonic + 7; playwarMeasure(time, (int) r);
				 * time += measure;
				 */

				// girl from ipanema
				/*
				 * double r = tonic; playpeaceMeasure(time, (int) r); time +=
				 * measure; r = tonic; playpeaceMeasure(time, (int) r); time +=
				 * measure; r = tonic + 2; playhappyMeasure(time, (int) r); time +=
				 * measure; r = tonic + 2; playhappyMeasure(time, (int) r); time +=
				 * measure; r = tonic + 2; playsadMeasure(time, (int) r); time +=
				 * measure; r = tonic + 7; playhappyMeasure(time, (int) r); time +=
				 * measure; r = tonic; playpeaceMeasure(time, (int) r); time +=
				 * measure; r = tonic; playpeaceMeasure(time, (int) r); time +=
				 * measure;
				 */

				// blue bossa

				double r = tonic;
				playsadMeasure(time, (int) r);
				time += measure;
				r = tonic;
				playsadMeasure(time, (int) r);
				time += measure;
				r = tonic + 5;
				playsadMeasure(time, (int) r);
				time += measure;
				r = tonic - 2;
				playhappyMeasure(time, (int) r);
				time += measure;
				r = tonic + 2;
				playwarMeasure(time, (int) r);
				time += measure;
				r = tonic - 5;
				playhappyMeasure(time, (int) r);
				time += measure;
				r = tonic;
				playsadMeasure(time, (int) r);
				time += measure;
				r = tonic;
				playsadMeasure(time, (int) r);
				time += measure;
				r = tonic - 9;
				playhappyMeasure(time, (int) r);
				time += measure;
				r = tonic - 4;
				playhappyMeasure(time, (int) r);
				time += measure;
				r = tonic - 11;
				playpeaceMeasure(time, (int) r);
				time += measure;
				r = tonic - 11;
				playpeaceMeasure(time, (int) r);
				time += measure;
				r = tonic + 2;
				playwarMeasure(time, (int) r);
				time += measure;
				r = tonic - 5;
				playhappyMeasure(time, (int) r);
				time += measure;
				r = tonic;
				playsadMeasure(time, (int) r);
				time += measure;
				r = tonic - 5;
				playhappyMeasure(time, (int) r);
				time += measure;

			}
			time += secondsPerBeat;
			catchUp(time);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Stop everything.
		synth.stop();
	}

	private void noteOn(double time, int noteNumber) {
		UnitVoice voice = allocator.allocate(noteNumber);
		double frequency = convertPitchToFrequency(noteNumber);
		double amplitude = 0.2;
		TimeStamp timeStamp = new TimeStamp(time);
		voice.noteOn(timeStamp, frequency, amplitude);
	}

	private void noteOff(double time, int noteNumber) {
		UnitVoice voice = allocator.off(noteNumber);
		if (voice != null) {
			voice.noteOff(new TimeStamp(time));
		}
	}

	double convertPitchToFrequency(double pitch) {
		final double concertA = 300.0;
		return concertA * Math.pow(2.0, ((pitch - 69) * (1.0 / 12.0)));
	}

	private void catchUp(double time) throws InterruptedException {
		synth.sleepUntil(time - advance);
	}

	private void playsadMeasure(double time, int base)
			throws InterruptedException {
		dutyCycle = 1.3;
		// build minor chord (1,4,8)
		int p1 = base;
		int p2 = base + 3;
		int p3 = base + 7;
		// pick a chord type
		int r = (int) (Math.random() * 3.0);
		if (r < 1)
			playChord1(time, p1, p2, p3);
		else if (r < 2)
			playChord2(time, p1, p2, p3);
		else
			playChord3(time, p1, p2, p3);
		// pick a noodle type
		int s = (int) (Math.random() * 3.0);
		if (s < 1)
			playNoodle1(time, p1 + 24, p2 + 24, p3 + 24);
		else if (s < 2)
			playNoodle2(time, p1 + 24, p2 + 24, p3 + 24);
		else
			playNoodle3(time, p1 + 24, p2 + 24, p3 + 24);
	}

	private void playhappyMeasure(double time, int base)
			throws InterruptedException {
		dutyCycle = 0.3;
		// build major chord (1,5,8)
		int p1 = base;
		int p2 = base + 4;
		int p3 = base + 7;
		int r = (int) (Math.random() * 3.0);
		if (r < 1)
			playChord1(time, p1, p2, p3);
		else if (r < 2)
			playChord2(time, p1, p2, p3);
		else
			playChord3(time, p1, p2, p3);
		int s = (int) (Math.random() * 3.0);
		if (s < 1)
			playNoodle1(time, p1 + 24, p2 + 24, p3 + 24);
		else if (s < 2)
			playNoodle2(time, p1 + 24, p2 + 24, p3 + 24);
		else
			playNoodle3(time, p1 + 24, p2 + 24, p3 + 24);
	}

	private void playpeaceMeasure(double time, int base)
			throws InterruptedException {
		dutyCycle = 1.3;

		// build maj7 chord (1,5,8,12)
		int p1 = base;
		int p2 = base + 4;
		int p3 = base + 7;
		int p4 = base + 11;

		// use overloaded functions for four parameter outputs.
		int r = (int) (Math.random() * 3.0);
		if (r < 1)
			playChord1b(time, p1, p2, p3, p4);
		else if (r < 2)
			playChord2b(time, p1, p2, p3, p4);
		else
			playChord3b(time, p1, p2, p3, p4);
		int s = (int) (Math.random() * 3.0);
		if (s < 1)
			playNoodle1b(time, p1 + 24, p2 + 24, p3 + 24, p4 + 24);
		else if (s < 2)
			playNoodle2b(time, p1 + 24, p2 + 24, p3 + 24, p4 + 24);
		else
			playNoodle3b(time, p1 + 24, p2 + 24, p3 + 24, p4 + 24);
	}

	private void playwarMeasure(double time, int base)
			throws InterruptedException {
		dutyCycle = 0.3;
		// build diminished chord (1,4,7)
		int p1 = base;
		int p2 = base + 3;
		int p3 = base + 6;
		int r = (int) (Math.random() * 3.0);
		if (r < 1)
			playChord1(time, p1, p2, p3);
		else if (r < 2)
			playChord2(time, p1, p2, p3);
		else
			playChord3(time, p1, p2, p3);
		int s = (int) (Math.random() * 3.0);
		if (s < 1)
			playNoodle1(time, p1 + 12, p2 + 12, p3 + 12);
		else if (s < 2)
			playNoodle2(time, p1 + 12, p2 + 12, p3 + 12);
		else
			playNoodle3(time, p1 + 12, p2 + 12, p3 + 12);

	}

	private void playChord1(double time, int p1, int p2, int p3)
			throws InterruptedException {
		double dur = dutyCycle * secondsPerBeat;
		playTriad(time, dur * 2, p1, p2, p3);
		time += secondsPerBeat * 2;
		playTriad(time, dur * 2, p1, p2, p3);
		time += secondsPerBeat * 2;
	}

	private void playChord1b(double time, int p1, int p2, int p3, int p4)
			throws InterruptedException {
		double dur = dutyCycle * secondsPerBeat;
		playQuad(time, dur * 2, p1, p2, p3, p4);
		time += secondsPerBeat * 0.50;
		playQuad(time, dur * 2, p1, p2, p3, p4);
		time += secondsPerBeat * 0.50;
	}

	private void playChord2(double time, int p1, int p2, int p3)
			throws InterruptedException {
		double dur = dutyCycle * secondsPerBeat;
		playTriad(time, dur, p1, p2, p3);
		time += secondsPerBeat;
		playTriad(time, dur * 2, p1, p2, p3);
		time += secondsPerBeat * 2;
		playTriad(time, dur / 3, p1, p2, p3);
		time += secondsPerBeat / 3;
		playTriad(time, dur / 3, p1, p2, p3);
		time += secondsPerBeat / 3;
		playTriad(time, dur / 3, p1, p2, p3);
		time += secondsPerBeat / 3;
	}

	private void playChord2b(double time, int p1, int p2, int p3, int p4)
			throws InterruptedException {
		double dur = dutyCycle * secondsPerBeat;
		playQuad(time, dur, p1, p2, p3, p4);
		time += secondsPerBeat;
		playQuad(time, dur * 2, p1, p2, p3, p4);
		time += secondsPerBeat * 2;
		playQuad(time, dur / 3, p1, p2, p3, p4);
		time += secondsPerBeat / 3;
		playQuad(time, dur / 3, p1, p2, p3, p4);
		time += secondsPerBeat / 3;
		playQuad(time, dur / 3, p1, p2, p3, p4);
		time += secondsPerBeat / 3;
	}

	private void playChord3(double time, int p1, int p2, int p3)
			throws InterruptedException {
		double dur = dutyCycle * secondsPerBeat;
		playTriad(time, dur, p1, p2, p3);
		time += secondsPerBeat;
		playTriad(time, dur, p1, p2, p3);
		time += secondsPerBeat;
		playTriad(time, dur, p1, p2, p3);
		time += secondsPerBeat;
		playTriad(time, dur, p1, p2, p3);
		time += secondsPerBeat;
	}

	private void playChord3b(double time, int p1, int p2, int p3, int p4)
			throws InterruptedException {
		double dur = dutyCycle * secondsPerBeat;
		playQuad(time, dur, p1, p2, p3, p4);
		time += secondsPerBeat;
		playQuad(time, dur, p1, p2, p3, p4);
		time += secondsPerBeat;
		playQuad(time, dur, p1, p2, p3, p4);
		time += secondsPerBeat;
		playQuad(time, dur, p1, p2, p3, p4);
		time += secondsPerBeat;
	}

	private void playNoodle1(double time, int p1, int p2, int p3) {
		double secondsPerNote = secondsPerBeat * 0.5;
		for (int i = 0; i < 8; i++) {
			int p = pickFromThree(p1, p2, p3);
			noteOn(time, p);
			noteOff(time + dutyCycle * secondsPerNote, p);
			time += secondsPerNote;
		}
	}

	private void playNoodle1b(double time, int p1, int p2, int p3, int p4) {
		double secondsPerNote = secondsPerBeat * 0.5;
		for (int i = 0; i < 8; i++) {
			int p = pickFromFour(p1, p2, p3, p4);
			noteOn(time, p);
			noteOff(time + dutyCycle * secondsPerNote, p);
			time += secondsPerNote;
		}
	}

	private void playNoodle2(double time, int p1, int p2, int p3) {
		double secondsPerNote = secondsPerBeat;
		for (int i = 0; i < 4; i++) {
			int p = pickFromThree(p1, p2, p3);
			noteOn(time, p);
			noteOff(time + dutyCycle * secondsPerNote, p);
			time += secondsPerNote;
		}
	}

	private void playNoodle2b(double time, int p1, int p2, int p3, int p4) {
		double secondsPerNote = secondsPerBeat;
		for (int i = 0; i < 4; i++) {
			int p = pickFromFour(p1, p2, p3, p4);
			noteOn(time, p);
			noteOff(time + dutyCycle * secondsPerNote, p);
			time += secondsPerNote;
		}
	}

	private void playNoodle3(double time, int p1, int p2, int p3) {
		double secondsPerNote = secondsPerBeat * .8;
		noteOn(time, p1);
		noteOff(time + dutyCycle * secondsPerNote, p1);
		time += secondsPerNote;
		noteOn(time, p2);
		noteOff(time + dutyCycle * secondsPerNote, p2);
		time += secondsPerNote;
		noteOn(time, p3);
		noteOff(time + dutyCycle * secondsPerNote, p3);
		time += secondsPerNote;
		noteOn(time, p2);
		noteOff(time + dutyCycle * secondsPerNote, p2);
		time += secondsPerNote;
		noteOn(time, p1);
		noteOff(time + dutyCycle * secondsPerNote, p1);
		time += secondsPerNote;

	}

	private void playNoodle3b(double time, int p1, int p2, int p3, int p4) {
		double secondsPerNote = secondsPerBeat * .57;
		noteOn(time, p1);
		noteOff(time + dutyCycle * secondsPerNote, p1);
		time += secondsPerNote;
		noteOn(time, p2);
		noteOff(time + dutyCycle * secondsPerNote, p2);
		time += secondsPerNote;
		noteOn(time, p3);
		noteOff(time + dutyCycle * secondsPerNote, p3);
		time += secondsPerNote;
		noteOn(time, p4);
		noteOff(time + dutyCycle * secondsPerNote, p4);
		time += secondsPerNote;
		noteOn(time, p3);
		noteOff(time + dutyCycle * secondsPerNote, p3);
		time += secondsPerNote;
		noteOn(time, p2);
		noteOff(time + dutyCycle * secondsPerNote, p2);
		time += secondsPerNote;
		noteOn(time, p1);
		noteOff(time + dutyCycle * secondsPerNote, p1);
		time += secondsPerNote;

	}

	private int pickFromThree(int p1, int p2, int p3) {
		int r = (int) (Math.random() * 3.0);
		if (r < 1)
			return p1;
		else if (r < 2)
			return p2;
		else
			return p3;
	}

	private int pickFromFour(int p1, int p2, int p3, int p4) {
		int r = (int) (Math.random() * 4.0);
		if (r < 1)
			return p1;
		else if (r < 2)
			return p2;
		else if (r < 3)
			return p3;
		else
			return p4;
	}

	private int pickFromEight(int p1, int p2, int p3, int p4, int p5, int p6,
			int p7, int p8) {
		int r = (int) (Math.random() * 8.0);
		if (r < 1)
			return p1;
		else if (r < 2)
			return p2;
		else if (r < 3)
			return p3;
		else if (r < 4)
			return p4;
		else if (r < 5)
			return p5;
		else if (r < 6)
			return p6;
		else if (r < 7)
			return p7;
		else
			return p8;
	}

	private void playTriad(double time, double dur, int p1, int p2, int p3)
			throws InterruptedException {
		noteOn(time, p1);
		noteOn(time, p2);
		noteOn(time, p3);
		double offTime = time + dur;
		noteOff(offTime, p1);
		noteOff(offTime, p2);
		noteOff(offTime, p3);
	}

	private void playQuad(double time, double dur, int p1, int p2, int p3,
			int p4) throws InterruptedException {
		noteOn(time, p1);
		noteOn(time, p2);
		noteOn(time, p3);
		noteOn(time, p4);
		double offTime = time + dur;
		noteOff(offTime, p1);
		noteOff(offTime, p2);
		noteOff(offTime, p3);
		noteOff(offTime, p4);
	}

	class MyVoiceFactory implements VoiceFactory {// creates synthesizer for
		// music output
		public UnitVoice createVoice(int tag) {
			// Circuit voice = new ClassicSynthVoice();
			// ClassicSynthVoice voice = new ClassicSynthVoice();
			//TriangleOscillator voice = new TriangleOscillator();
			 SquareOscillator voice = new SquareOscillator();
			 //SineOscillator voice = new SineOscillator();
			 // SawtoothOscillator voice = new SawtoothOscillator();
			synth.add(voice);
			voice.getOutput().connect(0, lineOut.input, 0);
			voice.getOutput().connect(0, lineOut.input, 1);
			return voice;
		}

	}
}
