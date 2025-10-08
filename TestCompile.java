public class TestCompile {
    public static void main(String[] args) {
        System.out.println("Teste de compilação - Java funcionando!");
        
        // Teste do método auxiliar repetir
        String linha = repetir("─", 20);
        System.out.println("Linha: " + linha);
    }
    
    // Método auxiliar para repetir strings (compatibilidade Java 8)
    private static String repetir(String str, int vezes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < vezes; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}