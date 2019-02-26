'''Ritorna un dizionario che rappresenta la parsificazione dell'oggetto in input
path: path del file da leggere
numberOfSpecialLines: numero di righe iniziali da parsificare diversamente rispetto alle altre
separatorOfLines: array singledimentional che mi dice quale separatore usare in ogni riga
keysOfLines: chiavi da usare per il dizionario per le varie righe.Si tratta di una matrice di stringhe bidimensionale'''
def readFile(path,numberOfSpecialLines,separatorOfLines, keysOfLines):
    file = f.readlines()
    lineCounter = 0
    dictList = []
    for line in file:
        print "Parsing line {}: {} ...".format(lineCounter,line)
        currentSeparator = separatorOfLines[lineCounter]
        currentKeys = keysOfLines[lineCounter]
        print "\tCurrentSeparator: {}".format(currentSeparator)
        print "\tCurrentKeys: {}".format(currentKeys)
        splittedLine = line.split('.')
        keyCounter = 0
        lineDict = {}
        for(value in splittedLine):
            lineDict[currentKeys[lineDict]] = value
            keyCounter++
        dictList.append(lineDict)

        lineCounter++
    file.close()
    print dictList
    return dictList


if __name__ == '__main__':
    #TODO: test it and bestemmia it