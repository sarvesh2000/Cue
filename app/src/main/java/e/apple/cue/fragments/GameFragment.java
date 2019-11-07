package e.apple.cue.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import e.apple.cue.R;
import e.apple.cue.common.Shared;
import e.apple.cue.events.engine.FlipDownCardsEvent;
import e.apple.cue.events.engine.GameWonEvent;
import e.apple.cue.events.engine.HidePairCardsEvent;
import e.apple.cue.model.Game;
import e.apple.cue.ui.BoardView;
import e.apple.cue.ui.PopupManager;
import e.apple.cue.utils.Clock;
import e.apple.cue.utils.Clock.OnTimerCount;
import e.apple.cue.utils.FontLoader;
import e.apple.cue.utils.FontLoader.Font;

public class GameFragment extends BaseFragment {

	private BoardView mBoardView;
	private TextView mTime;
	private ImageView mTimeImage;
	private LinearLayout ads;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		ViewGroup view = (ViewGroup) inflater.inflate(R.layout.game_fragment, container, false);
		view.setClipChildren(false);
		((ViewGroup)view.findViewById(R.id.game_board)).setClipChildren(false);
		mTime = (TextView) view.findViewById(R.id.time_bar_text);
		mTimeImage = (ImageView) view.findViewById(R.id.time_bar_image);
		FontLoader.setTypeface(Shared.context, new TextView[] {mTime}, Font.GROBOLD);
		mBoardView = BoardView.fromXml(getActivity().getApplicationContext(), view);
		FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.game_container);
		frameLayout.addView(mBoardView);
		frameLayout.setClipChildren(false);

		// build board
		buildBoard();
		Shared.eventBus.listen(FlipDownCardsEvent.TYPE, this);
		Shared.eventBus.listen(HidePairCardsEvent.TYPE, this);
		Shared.eventBus.listen(GameWonEvent.TYPE, this);
		
		return view;
	}
	
	@Override
	public void onDestroy() {
		Shared.eventBus.unlisten(FlipDownCardsEvent.TYPE, this);
		Shared.eventBus.unlisten(HidePairCardsEvent.TYPE, this);
		Shared.eventBus.unlisten(GameWonEvent.TYPE, this);
		super.onDestroy();
	}

	private void buildBoard() {
		Game game = Shared.engine.getActiveGame();
		int time = game.boardConfiguration.time;
		setTime(time);
		mBoardView.setBoard(game);
		
		startClock(time);
	}
	
	private void setTime(int time) {
		int min = time / 60;
		int sec = time - min*60;
		mTime.setText(" " + String.format("%02d", min) + ":" + String.format("%02d", sec));
	}

	private void startClock(int sec) {
		Clock clock = Clock.getInstance();
		clock.startTimer(sec*1000, 1000, new OnTimerCount() {
			
			@Override
			public void onTick(long millisUntilFinished) {
				setTime((int) (millisUntilFinished/1000));
			}
			
			@Override
			public void onFinish() {
				setTime(0);
			}
		});
	}

	@Override
	public void onEvent(GameWonEvent event) {
		mTime.setVisibility(View.GONE);
		mTimeImage.setVisibility(View.GONE);
		PopupManager.showPopupWon(event.gameState);
	}

	@Override
	public void onEvent(FlipDownCardsEvent event) {
		mBoardView.flipDownAll();
	}

	@Override
	public void onEvent(HidePairCardsEvent event) {
		mBoardView.hideCards(event.id1, event.id2);
	}

}
