
/* 
 * Michael Wu 
 * mvw5mf
 * Homework 4 
 * section 100
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class HW4test 
{
	
	@Test
	public void songGetPlayTimeSecondsTest() 
	{
		Song s = new Song("Logic", "I Am the Greatest", 4, 20);
		assertEquals(260, s.getPlayTimeSeconds());
	}
	
	@Test
	public void songGetPlayTimeSecondsTest2() 
	{
		Song s = new Song("Logic", "I Am the Greatest");
		s.setMinutes(4);
		s.setSeconds(20);
		assertEquals(260, s.getPlayTimeSeconds());
	}
	
	@Test
	public void songCompareToTest() 
	{
		Song s1 = new Song("LogicA", "Cinderella Man", 3, 50);
		Song s2 = new Song("LogicB", "I Am the Greatest3", 3, 50);
		assertTrue(s1.compareTo(s2) < 0);
	}
	
	@Test
	public void songCompareToTest2() 
	{
		Song s1 = new Song("Logic", "Cinderella Man", 4, 20);
		Song s2 = new Song("Logic", "I Am the Greatest4", 4, 20);
		assertTrue(s1.compareTo(s2) < 0);
	} 
	
	@Test
	public void songEqualsTest()
	{
		Song s1 = new Song("Logic", "I Am the Greatest", 6, 90);
		Song s2 = new Song("Logic", "I Am the Greatest", 6, 90);
		assertEquals(s1, s2);
	}
	
	@Test
	public void songEqualsTest2() 
	{
		Song s1 = new Song("Logic", "I Am the Greatest", 1, 50);
		Song s2 = new Song(s1);
		assertEquals(s1, s2);
	}
	
	@Test
	public void playListGetPlayTimeSecondsTest() 
	{
		PlayList p = new PlayList();
		p.addSong(new Song("Logic", "I Am the Greatest", 4, 20));
		assertEquals(260, p.getPlayTimeSeconds());
	}
	
	@Test
	public void playListGetPlayTimeSecondsTest2() 
	{
		PlayList pOriginal = new PlayList();
		PlayList pNested   = new PlayList();
		
		pOriginal.addSong(new Song("Kendrick Lamar","Cinderella Man", 2, 30)); // 150 seconds
		pNested.addSong(new Song("Eminem", "Cinderella Man", 3, 40));  // 230 seconds
		pNested.addSong(new Song("Ed-Two", "I Am the Greatest3", 4, 50));  // 280 seconds
		pOriginal.addPlayList(pNested);
		assertEquals(660, pOriginal.getPlayTimeSeconds());      // 660 seconds total
	}
	
	@Test
	public void playListAddSongTest() 
	{
		PlayList p = new PlayList();
		assertTrue(p.addSong(new Song("Logic", "I Am the Greatest", 3, 50)));
	}
	
	@Test
	public void playListAddSongTest2() 
	{
		PlayList p = new PlayList();
		Song s = new Song("Logic", "I Am the Greatest", 3, 50);
		p.addSong(s);
		assertTrue(p.getPlayableList().contains(s));
	}
	
	@Test
	public void playListClearTest() 
	{
		PlayList p = new PlayList();
		assertFalse(p.clear());
	}
	
	@Test
	public void playListClearTest2() 
	{
		PlayList p = new PlayList();
		p.addSong(new Song("Logic", "I Am the Greatest", 3, 50));
		assertTrue(p.clear());
	}

	
	@Test
	public void playListRemovePlayableTest() 
	{
		PlayList p = new PlayList();
		Playable play = p.removePlayable(0);
		assertEquals(null, play);
	}
	
	@Test
	public void playListRemovePlayableTest2() 
	{
		PlayList p = new PlayList();
		Song s = new Song("Logic", "I Am the Greatest", 3, 50);
		p.addSong(s);
		Playable play = p.removePlayable(0);
		assertEquals(s, play);
	}
	
	@Test
	public void playListRemovePlayableTest3() 
	{
		PlayList p = new PlayList();
		Song s1 = new Song("Kendrick Lamar", "Cinderella Man", 3, 50);
		Song s2 = new Song("Eminem", "Cinderella Man", 3, 50);
		p.addSong(s1);
		p.addSong(s2);
		p.addSong(s2);
		p.addSong(s2);
		Playable play = p.removePlayable(s2);
		assertEquals(s2, play);
	}
	
	@Test
	public void playListRemovePlayableTest4() 
	{
		PlayList p = new PlayList();
		Song s1 = new Song("Kendrick Lamar", "Cinderella Man", 3, 50);
		Song s2 = new Song("Eminem", "Cinderella Man", 3, 50);
		p.addSong(s1);
		p.addSong(s2);
		p.addSong(s2);
		p.addSong(s2);
		p.removePlayable(s2);
		assertEquals(1, p.size());
	}
	
	@Test
	public void playListGetPlayableTest() 
	{
		PlayList p = new PlayList();
		Playable play = p.getPlayable(0);
		assertEquals(null, play);
	}
	
	@Test
	public void playListGetPlayableTest2() 
	{
		PlayList p = new PlayList();
		Song s1 = new Song("Kendrick Lamar", "Cinderella Man", 3, 50);
		Song s2 = new Song("Eminem", "Cinderella Man", 3, 50);
		p.addSong(s1);
		p.addSong(s2);
		p.addSong(s2);
		p.addSong(s2);
		Playable play = p.getPlayable(2);
		assertEquals(s2, play);
	}
	
	@Test
	public void playListAddPlayListTest() 
	{
		PlayList p = new PlayList();
		PlayList p1 = new PlayList("Same");
		PlayList p2 = new PlayList("Same");
		p.addPlayList(p1);
		p.addPlayList(p2);
		assertEquals(1, p.getPlayableList().size());
	}
	
	@Test
	public void playListAddPlayListTest2() 
	{
		PlayList p = new PlayList();
		PlayList p1 = new PlayList("A Name");
		PlayList p2 = new PlayList("Try Again");
		p.addPlayList(p1);
		p.addPlayList(p2);
		assertEquals(2, p.getPlayableList().size());
	}
	
	@Test
	public void playListSizeTest() {
		PlayList p = new PlayList();
		for(int x=0; x < 10; x++) {
			p.addSong(new Song("Logic", "I Am the Greatest"));
		}
		assertEquals(10, p.size());
	}
	@Test
	public void playListSizeTest2() 
	{
		PlayList p1 = new PlayList();
		PlayList p2 = new PlayList();
		PlayList p3 = new PlayList();
		for(int x=0; x < 10; x++) {
			p1.addSong(new Song("Logic", "I Am the Greatest"));
			p2.addSong(new Song("Logic", "I Am the Greatest"));
			p3.addSong(new Song("Logic", "I Am the Greatest"));
		}
		p1.addPlayList(p2);
		p2.addPlayList(p3);
		assertEquals(30, p1.size());
	}
	
	@Test
	public void playListSortByName()
	{
		PlayList p = new PlayList();
		for(int x=0; x < 5; x++) {
			p.addSong(new Song("Logic" + x, "I Am the Greatest" + (4-x)));
		}
		p.sortByName();
		assertEquals(new Song("Logic4", "I Am the Greatest0"), p.getPlayableList().get(0));
	}

	@Test
	public void playListSortByName2() 
	{
		PlayList p = new PlayList();
		for(int x=0; x < 5; x++) {
			p.addSong(new Song("Logic", "I Am the Greatest" + (4-x)));
		}
		p.sortByName();
		assertFalse(new Song("Kendrick Lamar", "I Am the Greatest4").equals(p.getPlayableList().get(0)));
	}
	
	@Test
	public void playListSortByTime() 
	{
		PlayList p = new PlayList();
		for(int x=0; x < 10; x++) {
			p.addSong(new Song("Logic", "I Am the Greatest" + x, 9-x, 0));
		}
		p.sortByTime();
		assertEquals(new Song("Logic", "I Am the Greatest9", 0, 0), p.getPlayableList().get(0));
	}

	@Test
	public void playListSortByTime2() 
	{
		PlayList p = new PlayList();
		for(int x=0; x < 5; x++) {
			p.addSong(new Song("Logic", "I Am the Greatest" + x, 4-x, 0));
		}
		p.sortByTime();
		assertFalse(new Song("Logic", "I Am the Greatest0", 4, 0).equals(p.getPlayableList().get(0)));
	}
	
}
