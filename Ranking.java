
public class Ranking {
    
    private SuperViloes raiz;

    public Ranking() {
        this.raiz = null;
    }

    public SuperViloes getRaiz(){
        return raiz;
    }

    public void adicionaVilao(SuperViloes vilao) {        
        if (raiz == null) {
            raiz = vilao;
            return;
        }
        
        SuperViloes atual = raiz;
        
        while (true) {
            SuperViloes pai = atual;
            if (vilao.getNivelDeMaldade() < atual.getNivelDeMaldade()) {
                atual = atual.getEsquerda();
                if (atual == null) {
                    pai.setEsquerda(vilao);
                    return;
                }
            } else {
                atual = atual.getDireita();
                if (atual == null) {
                    pai.setDireita(vilao);
                    return;
                }
            }
        }
    }
    

    private boolean vilaoRemovido; 

    public void removeVilao(String nomeVilao) {
    vilaoRemovido = false; 
    raiz = removeVilaoRecursivo(raiz, nomeVilao);
    if (vilaoRemovido) {
        System.out.println(nomeVilao + " foi removido com sucesso do ranking!");
    } else {
        System.out.println(nomeVilao + " não foi encontrado no ranking!");
    }
}


private SuperViloes removeVilaoRecursivo(SuperViloes atual, String nomeVilao) {
    if (atual == null) {
        return null;
    }

    
    if (nomeVilao.equals(atual.getNome())) {
        vilaoRemovido = true; 
        // Caso 1: Nenhum filho
        if (atual.getEsquerda() == null && atual.getDireita() == null) {
            return null;
        }

        // Caso 2: Apenas um filho
        if (atual.getEsquerda() == null) {
            return atual.getDireita();
        } else if (atual.getDireita() == null) {
            return atual.getEsquerda();
        }

        // Caso 3: Dois filhos - encontrar o sucessor in-order
        SuperViloes sucessor = encontrarSucessor(atual.getDireita());
        
        // Substitui os dados do vilão pelo sucessor
        atual.setNome(sucessor.getNome());
        atual.setNivelDeMaldade(sucessor.getNivelDeMaldade());

        // Remove o sucessor
        atual.setDireita(removeVilaoRecursivo(atual.getDireita(), sucessor.getNome()));
    } 
    else {
        // Busca recursiva para encontrar o vilão pelo nome
        atual.setEsquerda(removeVilaoRecursivo(atual.getEsquerda(), nomeVilao));
        atual.setDireita(removeVilaoRecursivo(atual.getDireita(), nomeVilao));
    }

    return atual;
}

    private SuperViloes encontrarSucessor(SuperViloes node) {
        SuperViloes atual = node;
        while (atual.getEsquerda() != null) {
            atual = atual.getEsquerda();
        }
        return atual;
    }

    public SuperViloes buscaMaiorNivelDeMaldade(SuperViloes node) {
        if (node == null) {
            return null;
        }

        SuperViloes maiorEsquerda = buscaMaiorNivelDeMaldade(node.getEsquerda());
        SuperViloes maiorDireita = buscaMaiorNivelDeMaldade(node.getDireita());
        SuperViloes maiorAtual = node;

        if (maiorEsquerda != null && maiorEsquerda.getNivelDeMaldade() > maiorAtual.getNivelDeMaldade()) {
            maiorAtual = maiorEsquerda;
        }

        if (maiorDireita != null && maiorDireita.getNivelDeMaldade() > maiorAtual.getNivelDeMaldade()) {
            maiorAtual = maiorDireita;
        }
    
        return maiorAtual;
    }

    public int separar(SuperViloes[] array, int ini, int fim){
        SuperViloes pivo;
        int esq;
        pivo = array[ini];
        esq = 0;

        while (ini<fim) {
            if(esq==0){
                if(pivo.getNivelDeMaldade() >= array[fim].getNivelDeMaldade()){
                    array[ini] = array[fim];
                    ini++;
                    esq = 1;
                }
                else{
                fim--;
                }
            }
            else{
                if (pivo.getNivelDeMaldade() < array[ini].getNivelDeMaldade()){
                    array[fim] = array[ini];
                    fim--;
                    esq = 0;
                }
                else{
                    ini++;
                }
            }
        }
        array[fim] = pivo;
        return fim;
    }

    public void ordenaViloes(SuperViloes[] array, int ini, int fim){
        int k;

        if(fim>ini){
            k = separar(array, ini, fim);
            ordenaViloes(array, ini, k-1);
            ordenaViloes(array, k+1, fim);
        }
        
    }
}



