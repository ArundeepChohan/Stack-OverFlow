import os
import shutil
#add source folder
src=""
src_files = os.listdir(src)
print(src_files)
i=0
for file_name in src_files:
    full_file_name = os.path.join(src, file_name)
    print(full_file_name)
    if os.path.isfile(full_file_name)& full_file_name.endswith("_ppt.csv"):
        i+=1
        dirName="SIM"+str(i)
        try:
        # Create target Directory
           os.mkdir(dirName)
           print("Directory " , dirName ,  " Created ") 
        except FileExistsError:
           print("Directory " , dirName ,  " already exists")
        if not os.path.exists(dirName):
           os.mkdir(dirName)
           print("Directory " , dirName ,  " Created ")
        else:    
           print("Directory " , dirName ,  " already exists")
        shutil.copy(full_file_name, dirName)
