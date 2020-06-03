package Controls;

public class PlayState {
	private static boolean creative = false;
	private static boolean spectator = true;

	public static boolean isCreative() {
		return creative;
	}

	public static void setCreative(boolean creative) {
		PlayState.creative = creative;
	}

	public static boolean isSpectator() {
		return spectator;
	}

	public static void setSpectator(boolean spectator) {
		PlayState.spectator = spectator;
	}
}
