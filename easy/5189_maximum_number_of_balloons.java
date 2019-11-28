class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] balloons = new int[5];//a, b, l, o, n
        for(int i = 0; i < text.length(); i ++) {
            switch (text.charAt(i)) {
                case 'a': balloons[0]++;
                    break;
                case 'b': balloons[1]++;
                    break;
                case 'l': balloons[2]++;
                    break;
                case 'o': balloons[3]++;
                    break;
                case 'n': balloons[4]++;
                    break;
                default:
                    break;
            }
        }
        balloons[2] /= 2;
        balloons[3] /= 2;
        Arrays.sort(balloons);
        return balloons[0];
    }
}
