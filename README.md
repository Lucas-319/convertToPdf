# convertToPdf

O `convertToPdf` é uma ferramenta de conversão que permite enviar arquivos no formato `.docx` e recebê-los convertidos em arquivos `.pdf` codificados em base64. Este projeto visa simplificar o processo de conversão de documentos, tornando-o rápido e eficiente.

## Como Funciona

1. **Envio do Arquivo**: O usuário envia um arquivo `.docx`.
2. **Conversão**: O arquivo é processado e convertido para o formato `.pdf`.
3. **Retorno**: O arquivo `.pdf` é retornado como uma string em base64.

## Bibliotecas Utilizadas

O projeto utiliza várias dependências para garantir a conversão eficiente dos arquivos. Algumas das bibliotecas principais incluem:
- Apache PDFBox
- iTextPDF
- Apache POI

## Observações

- **Compatibilidade**: O projeto pode apresentar problemas de compatibilidade com diferentes versões de documentos `.docx`. É recomendável salvar os arquivos no formato do Word 2007 ou anterior para garantir uma conversão bem-sucedida.

## Exemplo de Uso

(/convertToPdf/src/main/resources/templates/ConvertToPdf.png)

O exemplo acima mostra como a ferramenta funciona.
