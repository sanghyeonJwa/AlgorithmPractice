import java.util.*;

class Solution {
    
    class Music implements Comparable<Music> {
        String musicName;
        int playTime;
        int idx; // 입력 순서

        public Music(String musicName, int playTime, int idx) {
            this.musicName = musicName;
            this.playTime = playTime;
            this.idx = idx;
        }

        @Override
        public int compareTo(Music o) {
            if (this.playTime != o.playTime) {
                return o.playTime - this.playTime; // 재생시간 내림차순
            } else {
                return this.idx - o.idx; // 재생시간 같으면 입력 순서 오름차순
            }
        }
    }

    public String solution(String m, String[] musicinfos) {
        m = replaceSharp(m); // m 전처리

        List<Music> musicList = new ArrayList<>();

        for (int i = 0; i < musicinfos.length; i++) {
            String[] musicArr = musicinfos[i].split(",");

            int minutes1 = toMinutes(musicArr[0]);
            int minutes2 = toMinutes(musicArr[1]);
            int minutes = (minutes2 - minutes1 + 24 * 60) % (24 * 60); // 자정 넘어가는 경우 처리

            String musicName = musicArr[2];
            String note = replaceSharp(musicArr[3]);

            // 실제 재생된 악보 만들기
            StringBuilder playedNote = new StringBuilder();
            int noteLength = note.length();
            for (int j = 0; j < minutes / noteLength; j++)
                playedNote.append(note);
            playedNote.append(note.substring(0, minutes % noteLength));

            if (playedNote.toString().contains(m)) {
                musicList.add(new Music(musicName, minutes, i));
            }
        }

        if (musicList.isEmpty()) {
            return "(None)";
        } else {
            Collections.sort(musicList);
            return musicList.get(0).musicName;
        }
    }

    public static int toMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    public static String replaceSharp(String s) {
        return s.replaceAll("C#", "c")
                .replaceAll("D#", "d")
                .replaceAll("F#", "f")
                .replaceAll("G#", "g")
                .replaceAll("A#", "a")
                .replaceAll("B#", "b");
    }
}