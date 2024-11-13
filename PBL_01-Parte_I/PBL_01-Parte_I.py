import random
def gerar_lista_aleatoria(tamanho):
return [random.randint(1, 100) for _ in range(tamanho)]
def verificar_numeros(lista):
for numero in lista:
if numero % 3 == 0:
print(f'{numero} é múltiplo de 3')
if numero % 2 == 0:
print(f'{numero} é par')
else:
print(f'{numero} é ímpar')
if __name__ == "__main__":
try:
tamanho_lista = int(input("Informe o tamanho da lista: "))
lista_aleatoria = gerar_lista_aleatoria(tamanho_lista)
verificar_numeros(lista_aleatoria)
except ValueError:
print("Por favor, insira um número inteiro válido.")
