# test
HYPERLINK "https://teams.microsoft.com/l/meetup-join/19:meeting_ODlkNzdiMmItMjFlZC00NWMxLWFjZmQtNWQzZDVjYmE3YzY0%40thread.v2/0?context=%7b%22Tid%22:%22f85ca5f1-aa23-4252-a83a-443d333b1fe7%22%2c%22Oid%22:%22b162e27b-1d91-47d0-a5b9-1cc38d1f6184%22%7d"https://teams.microsoft.com/l/meetup-join/19%3ameeting_ODlkNzdiMmItMjFlZC00NWMxLWFjZmQtNWQzZDVjYmE3YzY0%40thread.v2/0?context=%7b%22Tid%22%3a%22f85ca5f1-aa23-4252-a83a-443d333b1fe7%22%2c%22Oid%22%3a%22b162e27b-1d91-47d0-a5b9-1cc38d1f6184%22%7d 










spring test


set lines 250
set pages 1000
col Tablespace_Name for a30
col FILE_DIR for a80

SELECT ddf.tablespace_name "Tablespace_Name",
                     ddf.bytes/1024/1024 "Bytes(MB)",
                     (ddf.bytes - dfs.bytes)/1024/1024 "Used(MB)",
                     round(((ddf.bytes - dfs.bytes) / ddf.bytes) * 100, 2) "Percent(%)",
                     dfs.bytes/1024/1024 "Free(MB)",
                     round((1 - ((ddf.bytes - dfs.bytes) / ddf.bytes)) * 100, 2) "Free(%)",
                     ROUND(ddf.MAXBYTES / 1024/1024,2) "MaxBytes(MB)",
                     FILE_NAME "FILE_DIR"
              FROM  (SELECT tablespace_name, sum(bytes) bytes, sum(maxbytes) maxbytes, MAX(FILE_NAME) AS FILE_NAME
                       FROM   dba_data_files
                       GROUP BY tablespace_name) ddf,
                    (SELECT tablespace_name, sum(bytes) bytes
                       FROM   dba_free_space
                       GROUP BY tablespace_name) dfs
              WHERE ddf.tablespace_name = dfs.tablespace_name
              AND ddf.tablespace_name NOT IN ( 'SYSTEM','UNDO0','UNDO1','USR','TEMP','SYSSUB' )
                          ORDER BY ((ddf.bytes-dfs.bytes)/ddf.bytes) DESC ;
