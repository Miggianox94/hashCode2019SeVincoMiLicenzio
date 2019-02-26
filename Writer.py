#!/usr/bin/env python
# coding: utf-8

# In[4]:


'''Scrive i dati data nel file filename con modalità writemode senza nessuna formattazione aggiuntiva'''
def writeRaw(data, filename, writeMode = 'w'):
    with open(filename, writeMode) as f:
        f.write(data);
        
    f.close();


# In[15]:


'''Scrive la linea lineData nel file filename in modalità append senza nessuna formattazione aggiuntiva'''
def appendLine(lineData, filename):
    with open(filename, 'a') as f:
        f.write("\n");
        f.write(lineData); 
    f.close();


# In[49]:


'''Scrive la matrice data nel file filename. Ogni elemento è separato da separator,
ed ha EOL come carattere di terminazione di linea(tranne l'ultima)'''
def writeMatrix(data, filename, separator = ' ', EOL = "\n"):
    with open(filename, 'w') as f:
        for i in range(0, len(data)):
            if(i > 0):
                f.write(EOL);
                
            for j in range(0, len(data[i]) - 1):
                f.write(str(data[i][j]) + separator);
            
            f.write(str(data[i][-1]));
    f.close();


# In[50]:


'''Scrive la matrice data nel file filename. Ogni elemento è separato da separator,
ed ha EOL come carattere di terminazione di linea (tranne l'ultima) in modalità append'''
def appendMatrix(data, filename, separator = ' ', EOL = "\n"):
    with open(filename, 'a') as f:
        for i in range(0, len(data)):
            f.write(EOL);
            for j in range(0, len(data[i]) - 1):
                f.write(str(data[i][j]) + separator);
                
            f.write(str(data[i][-1]));        
    f.close();


# In[48]:


#writeRaw("sdakljenlfwoenifwoefinwoe\ndadjapsdoapskpo\n\npskdaspodkapso", "provaWriteRaw");
#appendLine("jdflsdkf","provaWriteRaw", 'a');
writeMatrix([[1,2,3],[4,5,6]], "provaMatrice.txt", "|");
appendMatrix([[7,8,9],[10,10,"01"]],"provaMatrice.txt", "|");

