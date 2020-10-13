#7.2 Write a program that prompts for a file name, then opens that file and reads through the file, looking for lines of the form:
#        X-DSPAM-Confidence:    0.8475
#Count these lines and extract the floating point values from each of the lines and compute the average
#of those values and produce an output as shown below.
#You can download the sample data at http://www.pythonlearn.com/code/mbox-short.txt when 
#you are testing below enter mbox-short.txt as the file name.

path = input('Please insert path: ')

lines = open(path, 'r')

count = 0
sum1 = float()

for line in lines:
    
    sline = line.split()
    if not line.startswith('X-DSPAM-Confidence:') or 1 > len(sline): continue
    count += 1
    
    # print(sline)
    
    sum1 = sum1 + float(sline[1])

print ('Average spam confidence:', sum1/count)
# print ('count = ', count)