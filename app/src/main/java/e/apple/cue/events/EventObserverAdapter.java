package e.apple.cue.events;

import e.apple.cue.events.engine.FlipDownCardsEvent;
import e.apple.cue.events.engine.GameWonEvent;
import e.apple.cue.events.engine.HidePairCardsEvent;
import e.apple.cue.events.ui.BackGameEvent;
import e.apple.cue.events.ui.DifficultySelectedEvent;
import e.apple.cue.events.ui.FlipCardEvent;
import e.apple.cue.events.ui.NextGameEvent;
import e.apple.cue.events.ui.ResetBackgroundEvent;
import e.apple.cue.events.ui.StartEvent;
import e.apple.cue.events.ui.ThemeSelectedEvent;


public class EventObserverAdapter implements EventObserver {

	public void onEvent(FlipCardEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(DifficultySelectedEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(HidePairCardsEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(FlipDownCardsEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(StartEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(ThemeSelectedEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(GameWonEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(BackGameEvent event) {
		throw new UnsupportedOperationException();		
	}

	@Override
	public void onEvent(NextGameEvent event) {
		throw new UnsupportedOperationException();		
	}

	@Override
	public void onEvent(ResetBackgroundEvent event) {
		throw new UnsupportedOperationException();		
	}

}
