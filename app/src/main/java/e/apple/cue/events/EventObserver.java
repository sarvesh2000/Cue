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


public interface EventObserver {

	void onEvent(FlipCardEvent event);

	void onEvent(DifficultySelectedEvent event);

	void onEvent(HidePairCardsEvent event);

	void onEvent(FlipDownCardsEvent event);

	void onEvent(StartEvent event);

	void onEvent(ThemeSelectedEvent event);

	void onEvent(GameWonEvent event);

	void onEvent(BackGameEvent event);

	void onEvent(NextGameEvent event);

	void onEvent(ResetBackgroundEvent event);

}
